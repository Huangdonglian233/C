package com.huang.proxy.demo01;

public class Proxy implements Rent {
    private Host host;

    public Proxy() {

    }
    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
        seeHouse();
        hetong();
        fee();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    public void fee(){
        System.out.println("收中介费");
    }
    public void hetong(){
        System.out.println("签租赁合同");
    }
}
