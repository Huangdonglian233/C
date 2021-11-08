package com.huang.abstract1;

public class XiaoMiFactory implements ProductFactory{
    @Override
    public IphoneProduct iPhoneProduct() {
        return new XiaoMiPhone();
    }

    @Override
    public IRouterProduct iRouterProduct() {
        return new XiaoMiRouter();
    }
}
