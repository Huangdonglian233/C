package com.company;

public class Rec {
    double x;
    double y;
    double height;
    double width;
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    Rec(double x,double y,double width,double height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
}
