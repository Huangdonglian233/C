package com.company;

public class Geometry{
    Circle C;
    Rec r;

    public Circle getC() {
        return C;
    }

    public void setC(Circle c) {
        C = c;
    }

    public Rec getR() {
        return r;
    }

    public void setR(Rec r) {
        this.r = r;
    }
    Geometry(Circle C,Rec r){
        this.C=C;
        this.r=r;
    }
    public double getDistance(Circle C,Rec r){
        double m=r.x+r.getWidth()/2;
        double n=r.y-r.getHeight()/2;
        return Math.sqrt((C.x-m)*(C.x-m)+(C.y-n)*(C.y-n));
    }
}
