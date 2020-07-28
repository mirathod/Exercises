package org.milan.core.lambda;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Java 8 Lambda method references example
 *
 * @author Milan Rathod
 */
public class MethodReferencesDemo {

    public void staticMethodReferences() {
        List<String> messages = Arrays.asList("hello", "baeldung", "readers!");

        // Normal way
        messages.forEach(word -> StringUtils.capitalize(word));

        // Method references way
        messages.forEach(StringUtils::capitalize);
    }

    public void instanceMethodReferences() {
        List<Bicycle> bicycleList = new ArrayList<>();

        bicycleList.add(new Bicycle("TVS"));

        // Normal way
        bicycleList.stream()
                .sorted((o1, o2) -> new BicycleComparator().compare(o1, o2));

        // Method references way
        bicycleList.stream()
                .sorted(new BicycleComparator()::compare);

        List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);

        // Normal way
        numbers.stream()
                .sorted((a, b) -> a.compareTo(b));

        // Method references way
        numbers.stream()
                .sorted(Integer::compareTo);
    }

    public void constructorMethodReferences() {
        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");

        bikeBrands.stream()
                .map(Bicycle::new)
                .toArray(Bicycle[]::new);
    }

}

class Bicycle {

    private String brand;

    private Integer frameSize;

    public Bicycle(String brand) {
        this.brand = brand;
        this.frameSize = 10;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(Integer frameSize) {
        this.frameSize = frameSize;
    }
}

class BicycleComparator implements Comparator<Bicycle> {

    @Override
    public int compare(Bicycle o1, Bicycle o2) {
        return o1.getFrameSize().compareTo(o2.getFrameSize());
    }
}