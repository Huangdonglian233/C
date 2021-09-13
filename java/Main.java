package com.company;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Circle C=new Circle(1,1,3);
        Rec r=new Rec(3,4,2,3);
        Geometry g=new Geometry(C,r);
        System.out.println(g.getDistance(C,r));
    }
}
