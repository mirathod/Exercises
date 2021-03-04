package org.milan.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * LocalDate & LocalTime Examples
 *
 * @author Milan Rathod
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        Date date = new Date();
        Instant instant = Instant.ofEpochMilli(date.getTime());

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();

        System.out.println("java.util.Date: " + date);
        System.out.println("java.time.LocalDate: " + localDate);

        // Get Months, Years difference between two dates
        LocalDate past = LocalDate.of(1955, Month.MAY, 19);
        LocalDate present = LocalDate.now();
        Period age = Period.between(past, present);
        int years = age.getYears();
        int months = age.getMonths();
        System.out.println("number of years: " + years);
        System.out.println("number of months: " + months);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now: " + now);

        LocalDateTime dateTime = LocalDateTime.of(2015, Month.MAY, 21, 19, 30, 40);
        System.out.println("Specific Date: " + dateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm");
        String value = "2017-03-08 12:30";
        LocalDateTime parsedValue = LocalDateTime.parse(value, dateTimeFormatter);
        System.out.println(parsedValue);

    }
}
