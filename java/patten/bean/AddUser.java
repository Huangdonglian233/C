package cn.patten.bean;

import cn.patten.singleton.Connection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/*
    java实现的设计模式小程序，应用了策略模式，--单例模式，工厂模式，抽象工厂模式，--责任链模式。模拟的是Web系统针对不同用户提供不同的功能，可以在此基础上添加自己的代码。
     */
public class AddUser {
    String  path = "C:/Users/强联/Desktop/PattensPro/src/cn/patten/singleton/connection.properties";
    Scanner scanner = new Scanner(System.in);
    Properties prop = new Properties();
    //存储配置文件的对象
    FileOutputStream fos = null;
    //读取配置文件的对象
    FileInputStream fis = null;
    public void addUser(String str){
        try {
            System.out.println(path);
            fis = new FileInputStream(path);
            //读取配置文件中的账号密码，存储在Properties中
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("请输入用户名字：");
        String name = scanner.nextLine();
        if (prop.getProperty(name) != null) {
            System.out.println("该用户已存在！");
            return;
        }
        System.out.println("请输入密码：");
        String pass = scanner.next();
        try {
            //文件源路径对象   第一个参数是文件所在路径，
            //第二个参数是为了将后面操作的数据累计存入配置文件 当做日志使用
            //properties内不存储重复元素
            prop.clear();
            prop.setProperty(name,str+" "+name+" "+pass);
            fos = new FileOutputStream(path, true);
            //将properties中的数据写入文件
            prop.store(fos, null);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            closeStream(fis, fos);
            System.out.println("Administrator add a new user!");
        }
    }

    public void closeStream(FileInputStream fis, FileOutputStream fos) {
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fos = null;
        }
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fis = null;
        }
    }
}
