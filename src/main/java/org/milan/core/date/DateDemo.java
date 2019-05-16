package org.milan.core.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Example of {@link Date}
 *
 * @author Milan Rathod
 */
public class DateDemo {

    public static void main(String[] s) throws ParseException {
        Date date = new Date();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");

        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        System.out.println("Local Time:- " + date);

        // Convert Date to String
        String value = dateFormat.format(date);
        System.out.println("GMT Time:- " + value);

        // Convert String to Date
        Date parsedDate = dateFormat.parse(value);
        System.out.println("String to Date:- " + parsedDate);

        // Compare Dates
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date date1 = dateFormat.parse("6/22/1989");
        Date date2 = dateFormat.parse("5/22/1989");

        System.out.println(date1.after(date2));
        System.out.println(date1.before(date2));
        System.out.println(date1.equals(date2));
        System.out.println(date1.compareTo(date2));
    }

}
