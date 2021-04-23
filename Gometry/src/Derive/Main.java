package Derive;

public class Main {
    public static void main(String[] args) throws Exception{
        Father[]ms=new Father[10];
        for(int i=0;i<10;i++){
            double r=Math.random();
            if(r>0.8)
                ms[i]=new Father();
            else if(r>0.5)
                ms[i]=new Son();
            else
                ms[i]=new Grandson();
        }

        System.out.println("Father:"+Father.count);
        System.out.println("Son:"+Son.count);
        System.out.println("Grandson:"+Grandson.count);
    }
}
