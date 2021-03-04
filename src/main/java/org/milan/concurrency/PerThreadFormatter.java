package org.milan.concurrency;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Uses of {@link ThreadLocal}
 *
 * @author Milan Rathod
 */
public class PerThreadFormatter {

    private PerThreadFormatter() {
    }

    private static final ThreadLocal<SimpleDateFormat> dateFormatHolder =
            ThreadLocal.withInitial(() -> {
                System.out.println("Creating SimpleDateFormat for Thread : " + Thread.currentThread().getName());
                return new SimpleDateFormat("dd/MM/yyyy");
            });

    /**
     * Every time there is a call for DateFormat, ThreadLocal will return calling
     * Thread's copy of SimpleDateFormat
     */
    public static DateFormat getDateFormat() {
        return dateFormatHolder.get();
    }

}
