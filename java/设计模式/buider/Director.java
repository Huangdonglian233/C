package com.huang.buider;

public class Director {

    public Product build(Builder builder){

        builder.builderA();
        builder.builderB();
        builder.builderC();
        builder.builderD();

        return builder.getProduct();
    }
}
