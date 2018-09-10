package org.milan.core.interfaces;

public class NestedInterfaceDemo {
	public static void main(String[] a) {

		// interfaces.PQR.abc=new XYZ();
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
