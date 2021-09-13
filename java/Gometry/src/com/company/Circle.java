package com.company;

public class Circle {
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    double x,y,radius;

    Circle(double x,double y,double r){
        this.x=x;
        this.y=y;
        this.radius=r;
    }
}
