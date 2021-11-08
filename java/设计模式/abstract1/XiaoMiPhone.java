package com.huang.abstract1;

public class XiaoMiPhone implements IphoneProduct{

    @Override
    public void start() {
        System.out.println("小米开启手机");
    }

    @Override
    public void shutDown() {
        System.out.println("小米关闭手机");
    }

    @Override
    public void callUp() {
        System.out.println("小米打电话");
    }

    @Override
    public void sentSMS() {
        System.out.println("小米发送信息");
    }
}
