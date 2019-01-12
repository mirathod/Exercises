package org.milan.core.io;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public final class FileUtils {

    private FileUtils() {

    }

    public static String format(long time) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(new Date(time));
    }
}
