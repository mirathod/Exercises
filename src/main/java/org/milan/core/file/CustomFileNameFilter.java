package org.milan.core.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Custom File Name Filter
 *
 * @author Milan Rathod
 */

public class CustomFileNameFilter implements FilenameFilter {

    private String fileFormat;

    public CustomFileNameFilter(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(this.fileFormat);
    }
}
