package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link ThePsychicType}
 *
 * @author Milan Rathod
 */
public class ThePsychicTypeTest {

    @Test
    public void testIsReachable() {
        ThePsychicType thePsychicType = new ThePsychicType();
        boolean result = thePsychicType.isReachable(new int[]{3, 4, 2, 5, 5}, 1, 4);

        Assert.assertTrue(result);
    }
}