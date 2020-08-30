package org.milan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milan Rathod
 */
public class SuppressWarnings {

    private List versions;

    public SuppressWarnings() {
        this.versions = new ArrayList();
    }

    @java.lang.SuppressWarnings({"unchecked"})
    public void addVersion(String version) {
        versions.add(version);
    }

    public static void main(String[] args) {
        new SuppressWarnings().addVersion("test");
    }
}
