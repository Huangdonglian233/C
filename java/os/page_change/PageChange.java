package com.huang.os.page_change;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PageChange {
    private static int num;
    private static int max;
    private static String al;
    private static int current2 = 0;
    private static List<Integer> pages = new ArrayList<>();
    private static List<Integer> runPages;
    private static List<String> interrupt = new ArrayList<>();
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        System.out.println("请输入作业数目：");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        System.out.println("请输入作业序列：");
        for (int i = 0; i < num; i++) {
            pages.add(scanner.nextInt());
        }
        System.out.println("请输入分配页数量：");
        max = scanner.nextInt();
        System.out.println("请输入要使用的算法：（OPT,FIFO,LRU)");
        al = scanner.next();
        List<Integer> result = null;
        while (judge()) {
            if (al.equals("OPT") || al.equals("opt")) {
                result = optimal();
            } else if (al.equals("FIFO") || al.equals("fifo")) {
                result = fifo();
            } else if (al.equals("LRU") || al.equals("lru")) {
                result = lru();
            }
            print(result);
        }
    }

    public static void print(List<Integer> result){
        for (int re:result) {
            System.out.print(re+" ");
        }
        if(current2 == 0) {
            System.out.print("\t\t\t\t\t\t" + interrupt.get(current2));
        }else {
            System.out.print("\t\t\t\t\t" + interrupt.get(current2));
        }
        current2++;
        System.out.println();
    }

    public static boolean judge(){
        if(!pages.isEmpty()){
            return true;
        }
        return false;
    }

    public static List<Integer> optimal(){
        if(runPages==null){
            runPages = new ArrayList<>();
            runPages.add(0, pages.get(0));
            interrupt.add("×");
        }else if(runPages.size()<max){
            runPages.add(0, pages.get(0));
            interrupt.add("×");
        }else {
            if(runPages.contains(pages.get(0))){
                interrupt.add("√");
            }else {
                int change = findChange();
                runPages.remove(change);
                runPages.add(0, pages.get(0));
                interrupt.add("×");
            }
        }
        pages.remove(0);
        return runPages;
    }

    public static int findChange(){
        int temp = 0;
        int change = 0;
        int cur = 0;
        int size = runPages.size();
        int i;
        while (cur<size){
            for (i = 0; i < pages.size(); i++) {
                if(!pages.contains(runPages.get(cur))){
                    change = cur;
                    return change;
                }else if(pages.get(i) ==  runPages.get(cur)){
                    if(i > temp){
                        change = cur;
                        temp = i;
                    }
                }
            }
            cur++;
        }
        return change;
    }

    public static List<Integer> fifo(){
        if(runPages == null){
            runPages = new ArrayList<>();
            runPages.add(0,pages.get(0));
            interrupt.add("×");
        }else if(runPages.size() < max){
            runPages.add(0,pages.get(0));
            interrupt.add("×");
        }else {
            if(runPages.contains(pages.get(0))){
                interrupt.add("√");
            }else {
                runPages.remove(2);
                runPages.add(0, pages.get(0));
                interrupt.add("×");
            }
        }
        pages.remove(0);
        return runPages;
    }

    public static List<Integer> lru(){
        if(runPages == null){
            runPages = new ArrayList<>();
            runPages.add(0,pages.get(0));
            interrupt.add("×");
        }else if(runPages.size() < max){
            runPages.add(0,pages.get(0));
            interrupt.add("×");
        }else {
            if(runPages.contains(pages.get(0))){
                interrupt.add("√");
            }else {
                interrupt.add("×");
            }
            runPages.remove(2);
            runPages.add(0, pages.get(0));
        }
        pages.remove(0);
        return runPages;
    }
}
//4 3 2 1 4 3 5 4 3 2 1 5