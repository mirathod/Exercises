package org.milan.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility for files
 *
 * @author Milan Rathod
 */
public final class FileUtil {

    private FileUtil() {

    }

    public static String format(long time) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(new Date(time));
    }
}
