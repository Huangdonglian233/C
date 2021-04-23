package Rational;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        Rational a;
        Rational b;
        Rational temp;
        Gcd gcd;
        gcd=new Gcd();
        a=new Rational();
        b=new Rational();
        temp=new Rational();
        Scanner Scanner=new Scanner(System.in);
        a.x= Scanner.nextInt();
        a.y= Scanner.nextInt();
        b.x= Scanner.nextInt();
        b.y= Scanner.nextInt();
        temp.x=a.x;
        temp.y=a.y;
        temp.add(b);
        int k= gcd.gcd1(temp.x, temp.y);
        System.out.printf("%d/%d\n",temp.x/k,temp.y/k);
        temp.x=a.x;
        temp.y=a.y;
        temp.mul(b);
        k= gcd.gcd1(temp.x, temp.y);
        System.out.printf("%d/%d\n",temp.x/k,temp.y/k);
        temp.x=a.x;
        temp.y=a.y;
        temp.div(b);
        k= gcd.gcd1(temp.x, temp.y);
        System.out.printf("%d/%d\n",temp.x/k,temp.y/k);
        temp.x=a.x;
        temp.y=a.y;
        temp.sub(b);
        k= gcd.gcd1(temp.x, temp.y);
        System.out.printf("%d/%d\n",temp.x/k,temp.y/k);
    }
}
