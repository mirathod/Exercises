package org.milan.core.interfaces.marker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link CustomMarker}
 *
 * @author Milan Rathod
 */
public class CustomMarkerTest {

    private CustomService customService;

    @Before
    public void init() {
        customService = new CustomService();
    }

    @Test
    public void testCustomMarker() {
        CustomMarker customMarker = new CustomMarkerClass();

        Assert.assertTrue(customService.delete(customMarker));
    }

    @Test
    public void testNormal() {
        NormalClass normalClass = new NormalClass();

        Assert.assertFalse(customService.delete(normalClass));
    }

}