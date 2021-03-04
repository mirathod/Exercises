package org.milan.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicProxyTest {

    @Test
    void test() {
        Map map = (Map) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
                new Class[]{Map.class},
                new TimingDynamicInvocationHandler(new HashMap<>()));

        map.put("hello", "world");

        assertEquals("world", map.get("hello"));


        CharSequence charSequence = (CharSequence) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
                new Class[]{CharSequence.class},
                new TimingDynamicInvocationHandler("Hello world"));

        assertEquals('l', charSequence.charAt(2));
        assertEquals(11, charSequence.length());
    }

}