package Rational;

public class Rational {
    int x,y;

    public Rational add(Rational b){

        this.x=x*b.y+y*b.x;
        this.y=y* b.y;
        return this;
    }
    public Rational sub(Rational b){
        this.x=x*b.y-b.x*y;
        this.y=y*b.y;
        return this;
    }
    public Rational mul(Rational b){
        this.x=x*b.x;
        this.y=y*b.y;
        return this;
    }
    public Rational div(Rational b){
        this.x=x*b.y;
        this.y=y*b.x;
        return this;
    }
}
