package org.milan.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Checked Exceptions
 */
public class CheckedException {

    private static final Logger LOG = LoggerFactory.getLogger(CheckedException.class);

    public void checkedExcpetion() {
        File f = new File("f:/out");

        try {
            f.createNewFile(); // checked exception
        } catch (IOException e) {
            LOG.error("Checked Excpetion caught by user {} ", e.getMessage());
        }
    }
}
