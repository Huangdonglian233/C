package com.huang.proxy.demo04;

import com.huang.proxy.demo02.UserService;
import com.huang.proxy.demo02.UserServiceImp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImp userService = new UserServiceImp();
        //代理角色：不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService);//设置要代理的对象
        UserService proxy =(UserService) pih.getProxy();
        proxy.del();
        proxy.add();
    }
}
