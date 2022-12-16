package org.example.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * author        yiliyang
 * date          2022-12-16
 * time          上午10:43
 * version       1.0
 * since         1.0
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service.class);
        enhancer.setCallback(new Service.MyMethodInterceptor());
        Service proxyObj = (Service) enhancer.create();
        proxyObj.test();
    }
}
