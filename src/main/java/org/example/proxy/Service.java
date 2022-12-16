package org.example.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * author        yiliyang
 * date          2022-12-16
 * time          上午10:45
 * version       1.0
 * since         1.0
 */
public class Service implements ServiceInterface {

    @Override
    public void test() {
        System.out.println("test");
        test1();
    }

    @Override
    public void test1() {
        System.out.println("test1");
        test2();
    }

    @Override
    public final void test2() {
        System.out.println("test2");
    }

    public static class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before proxy");
            methodProxy.invokeSuper(o, objects);
            System.out.println("after proxy");
            return null;
        }
    }

}
