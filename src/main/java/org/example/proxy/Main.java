package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author        yiliyang
 * date          2022-12-16
 * time          上午11:03
 * version       1.0
 * since         1.0
 * <p>
 * <p>
 * 不会每个方法去生成增强代码
 * before proxy
 * test
 * test1
 * test2
 * after proxy
 */
public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        ServiceInterface myProxy = (ServiceInterface) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                new Class[]{ServiceInterface.class},
                (proxy, method, arg) -> {
                    System.out.println("before proxy");
                    method.invoke(service, arg);
                    System.out.println("after proxy");
                    return null;
                });
        myProxy.test();
    }

}
