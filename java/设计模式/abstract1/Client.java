package com.huang.abstract1;

public class Client {
    public static void main(String[] args) {
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        IphoneProduct iphoneProduct = xiaoMiFactory.iPhoneProduct();
        iphoneProduct.callUp();
        iphoneProduct.sentSMS();

        IRouterProduct iRouterProduct = xiaoMiFactory.iRouterProduct();
        iRouterProduct.openWifi();
        iRouterProduct.setting();

        HuaWeiFactory HuaWeiFactory = new HuaWeiFactory();
        IphoneProduct phoneProduct = HuaWeiFactory.iPhoneProduct();
        phoneProduct.callUp();
        phoneProduct.sentSMS();

        IRouterProduct RouterProduct = HuaWeiFactory.iRouterProduct();
        RouterProduct.openWifi();
        RouterProduct.setting();
    }
}
