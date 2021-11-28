package com.huang.proxy.demo02;

public class Client {
    public static void main(String[] args) {
        UserServiceImp userService = new UserServiceImp();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();
        proxy.query();
    }
}
