package org.milan.misc;

/**
 * {@link @https://www.programcreek.com/2014/03/leetcode-compare-version-numbers-java/}
 *
 * @author Milan Rathod
 */
public class VersionsComparison {

    public int compareVersions(String version1, String version2) {

        // Base conditions
        if (version1 == null || version2 == null || version1.isEmpty() || version2.isEmpty()) {
            return 0;
        }

        version1 = transformVersion(version1);

        version2 = transformVersion(version2);

        return version1.compareTo(version2);

    }

    private String transformVersion(String version) {
        if (!version.contains(".")) {
            version += ".0";
        }

        if (version.startsWith(".")) {
            version = "0" + version;
        }

        if (version.endsWith(".")) {
            version += "0";
        }

        return version;
    }
}
