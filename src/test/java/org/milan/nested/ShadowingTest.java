package org.milan.nested;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShadowingTest {

    @Test
    void test() {
        Shadowing shadowing = new Shadowing();
        Shadowing.InnerClass innerClass = shadowing.new InnerClass();
        innerClass.run();
    }

}