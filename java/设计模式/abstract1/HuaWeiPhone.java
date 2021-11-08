package com.huang.abstract1;

public class HuaWeiPhone implements IphoneProduct{

    @Override
    public void start() {
        System.out.println("华为开启手机");
    }

    @Override
    public void shutDown() {
        System.out.println("华为关闭手机");
    }

    @Override
    public void callUp() {
        System.out.println("华为打电话");
    }

    @Override
    public void sentSMS() {
        System.out.println("华为发消息");
    }
}
