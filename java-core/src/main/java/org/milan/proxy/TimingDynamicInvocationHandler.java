package org.milan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * JDK dynamic proxy example
 *
 * @author Milan Rathod
 */
public class TimingDynamicInvocationHandler implements InvocationHandler {

    private static final Map<String, Method> methods = new HashMap<>();

    private Object target;

    public TimingDynamicInvocationHandler(Object target) {
        this.target = target;

        for (Method method : target.getClass().getDeclaredMethods()) {
            methods.put(method.getName(), method);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();

        Object object = methods.get(method.getName()).invoke(target, args);

        System.out.printf("Executing %s finished in %s ns\n", method.getName(), System.nanoTime() - start);

        return object;
    }
}
