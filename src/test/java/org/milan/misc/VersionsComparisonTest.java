package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link VersionsComparison}
 *
 * @author Milan Rathod
 */
public class VersionsComparisonTest {

    @Test
    public void testCompareVersions() {

        VersionsComparison versionsComparison = new VersionsComparison();

        int result = versionsComparison.compareVersions("1.0.1.0", "1.0.1.0");

        Assert.assertEquals(0, result);

        result = versionsComparison.compareVersions(".0.1.0", "1.0.1.0");

        Assert.assertEquals(-1, result);

        result = versionsComparison.compareVersions("1.0.1.", "1.0.1.0");

        Assert.assertEquals(0, result);

        result = versionsComparison.compareVersions("1.1.1.0", "1.0.1.0");

        Assert.assertEquals(1, result);

    }
}