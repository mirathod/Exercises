package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for {@link BreakupApp}
 *
 * @author Milan Rathod
 */
public class BreakupAppTest {

    @Test
    public void testGetDate() {
        List<String> list = new ArrayList<>();

        list.add("G: I want to go on 19");
        list.add("M: No that is not possible lets go on 21");
        list.add("G: No 19 is final and 21 is not");
        list.add("M: OKAY as you wish");

        BreakupApp breakupApp = new BreakupApp();

        String result = breakupApp.getDate(list);

        Assert.assertEquals("Date", result);
    }

}