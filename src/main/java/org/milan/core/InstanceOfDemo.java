package org.milan.core;

/**
 * Example of instanceOf keyword
 *
 * @author Milan Rathod
 */
public class InstanceOfDemo {

    public static void main(String[] a) {

        BluetoothDevice bluetoothDevice = new BluetoothDevice();

        Mobile mobile = new Mobile();

        Device device = new BluetoothDevice();

        if (mobile instanceof Mobile) {
            System.out.println("mobile is an instanceOf Mobile");
        }

        if (mobile instanceof BluetoothDevice) {
            System.out.println("mobile is an instanceOf A");
        }

        if (mobile instanceof Device) {
            System.out.println("mobile is an instanceOf Device");
        }

        if (bluetoothDevice instanceof BluetoothDevice) {
            System.out.println("bluetoothDevice is an instanceOf BluetoothDevice");
        }

        if (bluetoothDevice instanceof Mobile) {
            System.out.println("bluetoothDevice is an instanceOf Mobile");
        }

        if (bluetoothDevice instanceof Device) {
            System.out.println("bluetoothDevice is an instanceOf Device");
        }

        if (device instanceof BluetoothDevice) {
            System.out.println("device is an instanceOf BluetoothDevice");
        }
    }
}

interface Device {
}

class BluetoothDevice implements Device {
}

class Mobile extends BluetoothDevice {
}