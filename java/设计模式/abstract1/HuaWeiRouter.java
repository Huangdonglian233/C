package com.huang.abstract1;

public class HuaWeiRouter implements IRouterProduct{
    @Override
    public void start() {
        System.out.println("启动华为路由器");
    }

    @Override
    public void shutDown() {
        System.out.println("关闭华为路由器");
    }

    @Override
    public void openWifi() {
        System.out.println("华为打开WiFi");

    }

    @Override
    public void setting() {
        System.out.println("华为设置");

    }
}
