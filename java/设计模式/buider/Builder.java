package com.huang.buider;

//抽象的建造者：方法
public interface Builder {
    abstract void builderA();
    abstract void builderB();
    abstract void builderC();
    abstract void builderD();

    abstract Product getProduct();
}
