package com.huang.abstract1;
//抽象产品工厂
public interface ProductFactory {
    //生产手机
    IphoneProduct iPhoneProduct();
    //生产路由器
    IRouterProduct iRouterProduct();
}
