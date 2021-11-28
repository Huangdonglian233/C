package com.huang.proxy.demo03;

import com.huang.proxy.demo03.Rent;

//房东
public class Host implements Rent {

    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
