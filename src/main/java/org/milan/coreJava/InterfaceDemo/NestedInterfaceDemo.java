package org.milan.coreJava.InterfaceDemo;

public class NestedInterfaceDemo {
	public static void main(String[] a) {

		// InterfaceDemo.PQR.abc=new XYZ();
	}

}

class PQR {
	protected interface abc {
		void sayHello();
	}
}

class XYZ implements PQR.abc {

	public void sayHello() {
		System.out.println("Hello");
	}

}
