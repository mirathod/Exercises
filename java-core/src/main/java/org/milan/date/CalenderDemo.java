package org.milan.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Example of {@link Calendar}
 *
 * @author Milan Rathod
 */
public class CalenderDemo {

    public static void main(String[] args) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        // Get calender instance with the current date and time in the default locale and timezone.
        Calendar calendar = Calendar.getInstance();

        // Display current date information
        System.out.print("Date: ");
        System.out.print(months[calendar.get(Calendar.MONTH)]);
        System.out.print(" " + calendar.get(Calendar.DATE) + " ");
        System.out.println(calendar.get(Calendar.YEAR));

        // Display current time information
        System.out.print("Time: ");
        System.out.print(calendar.get(Calendar.HOUR) + ":");
        System.out.print(calendar.get(Calendar.MINUTE) + ":");
        System.out.println(calendar.get(Calendar.SECOND));

        calendar.add(Calendar.DAY_OF_MONTH, 1);

        System.out.println("After adding 1 day to current date " + calendar.getTime());

        // Set the time and date information and display it.
        calendar.set(Calendar.HOUR, 10);
        calendar.set(Calendar.MINUTE, 29);
        calendar.set(Calendar.SECOND, 22);
        System.out.print("Updated time: ");
        System.out.print(calendar.get(Calendar.HOUR) + ":");
        System.out.print(calendar.get(Calendar.MINUTE) + ":");
        System.out.println(calendar.get(Calendar.SECOND));

        GregorianCalendar gregorianCalendar = new GregorianCalendar(2016, Calendar.JULY, 1);

        System.out.println("Gregorian Calender Instance: " + gregorianCalendar.getTime());
    }
}
