package org.milan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test Class for {@link AutoBoxing}
 *
 * @author Milan Rathod
 */
class AutoBoxingTest {

    private AutoBoxing autoBoxing;

    @BeforeEach
    void setup() {
        autoBoxing = new AutoBoxing();
    }

    @Test
    void testComparisonUsingOperator() {
        Integer source = 100;
        Integer target = 100;

        boolean result = autoBoxing.comparisonUsingOperator(source, target);

        assertTrue(result);

        source = 160;
        target = 160;

        result = autoBoxing.comparisonUsingOperator(source, target);

        assertFalse(result);
    }

    @Test
    void testComparisonUsingMethod() {
        Integer source = 100;
        Integer target = 100;

        boolean result = autoBoxing.comparisonUsingMethod(source, target);

        assertTrue(result);

        source = 160;
        target = 160;

        result = autoBoxing.comparisonUsingMethod(source, target);

        assertTrue(result);
    }
}