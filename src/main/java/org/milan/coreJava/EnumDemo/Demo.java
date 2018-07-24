package org.milan.coreJava.EnumDemo;

public class Demo {
	// can be private , protected ,default and public as it is inside a class
	enum Days {
		// each of the below is object/instance of enum Days
		MONDAY(70), TUESDAY(70), WEDNESDAY(70), THURSDAY(70), FRIDAY(70), SATURDAY(70), SUNDAY(40) {

			@Override
			public int getFreeHours() {
				return 3;
			}

		};

		int salary;

		Days(int i) {
			this.salary = i;
		}

		public int getFreeHours() {
			return 1;
		}
	}

	public static void main(String[] a) {
		Days f[] = Days.values();

		for (Days d : f) {
			System.out.print("Day:-" + d.name() + " Ordinal Number:" + d.ordinal());
			System.out.println("  Salary:-" + d.salary + "  Free Hours " + d.getFreeHours());
		}

	}

}
