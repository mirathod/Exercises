package org.milan.interfaces;

/**
 * Car class
 *
 * @author Milan Rathod
 */
public class Car implements Vehicle, Alarm {

    @Override
    public String getBrand() {
        return "TATA";
    }

    @Override
    public String speedUp() {
        return "The car is speeding up!";
    }

    @Override
    public String slowDown() {
        return "The car is speeding down!";
    }

    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn() + " - " + Alarm.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Vehicle.super.turnAlarmOff() + " - " + Alarm.super.turnAlarmOff();
    }

    public int testHorsePower() {
        return Vehicle.getHorsePower(3500, 480);
    }
}
