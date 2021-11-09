package com.huang.buider;

public class Worker implements Builder{
    private Product product;
    public Worker(){
        product=new Product();
    }
    @Override
    public void builderA() {
        product.setBuilderA("地基");
        System.out.println("地基");
    }

    @Override
    public void builderB() {
        product.setBuilderB("钢筋工程");
        System.out.println("钢筋工程");
    }

    @Override
    public void builderC() {
        product.setBuilderC("铺电线");
        System.out.println("铺电线");

    }

    @Override
    public void builderD() {
        product.setBuilderD("粉刷");
        System.out.println("粉刷");

    }

    @Override
    public Product getProduct() {
        return product;
    }
}
