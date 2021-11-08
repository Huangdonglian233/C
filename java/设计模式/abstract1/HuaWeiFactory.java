package com.huang.abstract1;

public class HuaWeiFactory implements ProductFactory{
    @Override
    public IphoneProduct iPhoneProduct() {
        return new HuaWeiPhone();
    }

    @Override
    public IRouterProduct iRouterProduct() {
        return new HuaWeiRouter();
    }
}
