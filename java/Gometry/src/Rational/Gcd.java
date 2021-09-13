package Rational;

public class Gcd {
    int gcd1(int a, int b) {// 循环实现
        int k = 0;
        do {
            k = a % b;// 得到余数
            a = b;// 根据辗转相除法,把被除数赋给除数
            b = k;// 余数赋给被除数
            } while (k != 0);
        return a;// 返回被除数
        }
}
