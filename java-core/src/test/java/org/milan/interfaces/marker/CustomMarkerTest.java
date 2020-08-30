package org.milan.interfaces.marker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link CustomMarker}
 *
 * @author Milan Rathod
 */
class CustomMarkerTest {

    private CustomService customService;

    @BeforeEach
    void init() {
        customService = new CustomService();
    }

    @Test
    void testCustomMarker() {
        CustomMarker customMarker = new CustomMarkerClass();

        assertTrue(customService.delete(customMarker));
    }

    @Test
    void testNormal() {
        NormalClass normalClass = new NormalClass();

        assertFalse(customService.delete(normalClass));
    }

}