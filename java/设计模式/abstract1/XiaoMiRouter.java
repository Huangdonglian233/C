package com.huang.abstract1;

public class XiaoMiRouter implements IRouterProduct {

    @Override
    public void start() {
        System.out.println("启动小米路由器");
    }

    @Override
    public void shutDown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void openWifi() {
        System.out.println("小米打开WiFi");

    }

    @Override
    public void setting() {
        System.out.println("小米设置");

    }
}
