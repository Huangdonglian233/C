package com.huang.proxy.demo03;

import com.huang.proxy.demo03.Host;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(host);
        Rent proxy = (Rent) pih.getProxy();//动态生成proxy
        proxy.rent();
    }
}
