package org.milan.core;

import org.junit.Assert;
import org.junit.Test;
import org.milan.core.HashCalculation;

/**
 * Test Class for {@link HashCalculation}
 *
 * @author Milan Rathod
 */
public class HashCalculationTest {

    @Test
    public void testMD5() {
        HashCalculation hashCalculation = new HashCalculation();

        String result = hashCalculation.getHash("TestValue", "MD5");

        Assert.assertEquals("88cd0ddd513f40d78832bed84aae6c6d", result);
    }

    @Test
    public void testSha1() {
        HashCalculation hashCalculation = new HashCalculation();

        String result = hashCalculation.getHash("TestValue", "SHA-1");

        Assert.assertEquals("f76b6c62c20cd2208d0742ed0bb5d3071e87db18", result);
    }

    @Test
    public void testSha256() {
        HashCalculation hashCalculation = new HashCalculation();

        String result = hashCalculation.getHash("TestValue", "SHA-256");

        Assert.assertEquals("7eb6e13a46dda0fd9997b9d58416e9dc72de967b1a0cfe2597db17f2fb7a5c41", result);
    }
}