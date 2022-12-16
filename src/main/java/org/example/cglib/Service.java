package org.example.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * author        yiliyang
 * date          2022-12-16
 * time          上午10:45
 * version       1.0
 * since         1.0
 *
 * 除了final方法和static方法，其他方法都进行了增强
 * before proxy
 * test
 * before proxy
 * test1
 * test2
 * test3
 * after proxy
 * after proxy
 */
public class Service {
    public void test() {
        System.out.println("test");
        test1();
    }

    public void test1() {
        System.out.println("test1");
        test2();
    }

    public final void test2() {
        System.out.println("test2");
        test3();
    }

    public static void test3() {
        System.out.println("test3");
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
