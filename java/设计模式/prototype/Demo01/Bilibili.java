package com.huang.prototype.Demo01;

import java.util.Date;

/*
客户端
 */
public class Bilibili {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Video v1 = new Video("狂神说Java",date);
        Video v2 =(Video) v1.clone();
        System.out.println("v1=>"+v1);
        System.out.println("v2=>"+v1);
        System.out.println(v1.hashCode());
        //克隆


        System.out.println(v2.hashCode());
        v2.setName("Clone:狂神说java");
        System.out.println(v2);
    }
}
