package org.milan.hackerEarth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class UnitBalancer {

	public static void main(String[] args) {

        //Scanner
        Scanner scanner = new Scanner(System.in);
        String inputUnits = scanner.nextLine();
        
        String[] units = inputUnits.split(",");
        
        ConversionMap conversionMap = new ConversionMap();
        
        List<String> equations = new ArrayList<>();
        
        for (int i = 0; i<units.length-1; i++) {
        	String equation = scanner.nextLine();
        	String[] equationUnits = equation.split(" ");
        	equations.add(equationUnits[0] + equationUnits[2] + equationUnits[3]);
        	
        	conversionMap.addConversion(equationUnits[0], 1.0, equationUnits[3], Double.parseDouble(equationUnits[2]));
        }
        
        
        System.out.println(formatOutput(equations, conversionMap.getResult()));
        

	}
	
	private static String formatOutput (List<String> equations, List<String> sortedUnits) {
		String output = "1" + sortedUnits.get(0);
		int numberToMultiply = 1;
		for (int i=0 ; i <sortedUnits.size() - 1;) {
			String unitOne = sortedUnits.get(i);
			String unitTwo = sortedUnits.get(++i);
			String temp = equations.stream().filter(s -> (s.contains(unitOne) && s.contains(unitTwo))).findFirst().get();
			String[] number = temp.split("\\s");
			System.out.println(number);
			// numberToMultiply = Integer.parseInt(number[0])*numberToMultiply;
			output += " = " + numberToMultiply + unitTwo;
		}
		return output;
	}

}

class ConversionMap {
    
    // A map of units to a set of conversions they could have
    // Example possibility:
    // {"yards": Set[Conversion(3 "feet"), Conversion(36, "inches")]}
    private Map<String, Set<UnitConversion>> conversionMap = new HashMap<>();

    /**
     * Adds a conversion rule by mapping a unit to another unit
     * Example: addConversion("meters", 1000, "kilometers", 1)
     * @param unit1   The first unit
     * @param amount1 The amount of the first unit
     * @param unit2   The second unit
     * @param amount2 The amount of the second unit
     */
    public void addConversion(String unit1, double amount1, String unit2, double amount2) {
        // Create the two conversions
    	UnitConversion amountUnit1InUnit2 = new UnitConversion(unit2, amount2 / amount1),
                amountUnit2InUnit1 = new UnitConversion(unit1, amount1 / amount2);
        Set<UnitConversion> conversionsUnit1 = conversionMap.get(unit1),
                conversionsUnit2 = conversionMap.get(unit2);
        // If either unit has not been seen before, then create a set and add the unit
        if (conversionsUnit1 == null) {
            conversionsUnit1 = new HashSet<UnitConversion>();
            conversionMap.put(unit1, conversionsUnit1);
        }
        if (conversionsUnit2 == null) {
            conversionsUnit2 = new HashSet<UnitConversion>();
            conversionMap.put(unit2, conversionsUnit2);
        }
        conversionsUnit1.add(amountUnit1InUnit2);
        conversionsUnit2.add(amountUnit2InUnit1);
    }
    /**
     * Gets the shortest path that can be used to convert from one unit to another
     * @param unit1    The first unit
     * @param unit2    The second unit (destination unit)
     * @param visited  A map consisting of the shortest known paths to each unit we've visited so far
     * @return         One of the shortest conversion paths that can be used to convert between units or null if no such path can be found
     */
    public ConversionPath getConversionPath(String unit1, String unit2, Map<String, ConversionPath> visited) {
        // Get the currentPath used to get to the current unit
        ConversionPath currentPath = visited.get(unit1);
        // If unit1 and unit2 are the same, then we've reached the destination, return the path so far
        if (unit1.equals(unit2)) {
            return currentPath;
        }
        // Find all possible conversions one level deep from this unit
        Set<UnitConversion> possibleConversions = conversionMap.get(unit1);
        int minLength = Integer.MAX_VALUE;
        ConversionPath smallestPath = null;
        // Loop through each conversion
        for (UnitConversion conversion : possibleConversions) {
            ConversionPath path = visited.get(conversion.getUnitName());
            // If going to the unit through this unit is shorter than what was previously there
            // then search for the destination from that unit
            if (path == null || path.pathLength() > currentPath.pathLength() + 1) {
                // Update the path on the other unit, because there is now a shorter way to get there
                visited.put(conversion.getUnitName(), currentPath.addUnit(conversion.getUnitName()));
                // Get the path from the new unit to the destination unit
                ConversionPath newPath = getConversionPath(conversion.getUnitName(), unit2, visited);
                // If such a path exists and its length is less than the shortest length so far
                // update the shortest path and smallest length
                if (newPath != null && newPath.pathLength() < minLength) {
                    minLength = newPath.pathLength();
                    smallestPath = newPath;
                }
            }
        }
        return smallestPath;
    }

    /**
     * Obtains the shortest path used to convert between two units
     * @param unit1 The starting unit
     * @param unit2 The destination unit
     * @return A ConversionPath representing the shortest path to convert from unit1 to unit2
     */
    public ConversionPath getConversionPath(String unit1, String unit2) {
        ConversionPath path = new ConversionPath();
        Map<String, ConversionPath> visited = new HashMap<String, ConversionPath>();
        visited.put(unit1, path);
        return getConversionPath(unit1, unit2, visited);
    }

    public String toString() {
        return conversionMap.toString();
    }
    
    public List<String> getResult() {
    	List<String> units = conversionMap.keySet().stream().filter(s -> conversionMap.get(s).size() == 1).collect(Collectors.toList());
    	String largestUnit = null;
    	double unitAmount = -1.0;
    	for (String unit: units) {
    		if (conversionMap.containsKey(unit)) {
    			Set<UnitConversion> unitConversion = conversionMap.get(unit);
    			double targetUnitAmount = unitConversion.stream().findFirst().get().getUnitAmount();
    			if (targetUnitAmount > unitAmount) {
    				unitAmount = targetUnitAmount;
    				largestUnit = unit;
    			}
    			
    		}
    	}
    	units.remove(largestUnit);
    	String smallestUnit = units.stream().findFirst().get();
    	
    	List<String> result = new ArrayList<>();
    	
    	result.add(largestUnit);
    	result.addAll(getConversionPath(largestUnit, smallestUnit).toList());
    
    	return result;
    }
}



/**
 * A wrapper for String[], an array of units.
 * The path is immutable.
 * Example: to convert from seconds to hours the ConversionPath is ["minutes", "hours"]
 */
class ConversionPath {
    String[] units;
    /**
     * Creates a conversion path with the specified units.
     * @param units The units that this conversion path has
     */
    public ConversionPath(String... units) {
        this.units = units;
    }
    /**
     * Duplicates the array and adds a unit to it.
     * @param unit The unit to add
     * @return     A duplicated conversion path with the unit appended at the end
     */
    public ConversionPath addUnit(String unit) {
        String[] newUnits = Arrays.copyOf(units, units.length + 1);
        newUnits[units.length] = unit;
        return new ConversionPath(newUnits);
    }
    /**
     * Returns the length of the path.
     * @return The length of the path
     */
    public int pathLength() {
        return units.length;
    }
    public String toString() {
        return Arrays.toString(units);
    }
    public List<String> toList() {
    	return Arrays.asList(units);
    }
}



class UnitConversion {
	private String unitName;
	private double unitAmount;
	
	public UnitConversion(String unitName, double unitAmount) {
		super();
		this.unitName = unitName;
		this.unitAmount = unitAmount;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public double getUnitAmount() {
		return unitAmount;
	}
	public void setUnitAmount(double unitAmount) {
		this.unitAmount = unitAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(unitAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((unitName == null) ? 0 : unitName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnitConversion other = (UnitConversion) obj;
		if (Double.doubleToLongBits(unitAmount) != Double.doubleToLongBits(other.unitAmount))
			return false;
		if (unitName == null) {
			if (other.unitName != null)
				return false;
		} else if (!unitName.equals(other.unitName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UnitConversion [unitName=" + unitName + ", unitAmount=" + unitAmount + "]";
	}
	
	
}
