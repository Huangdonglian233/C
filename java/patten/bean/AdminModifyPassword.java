package cn.patten.bean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class AdminModifyPassword extends ModifyPassword{
	String  path = "C:/Users/强联/Desktop/PattensPro/src/cn/patten/singleton/connection.properties";
	Scanner scanner = new Scanner(System.in);
	Properties prop = new Properties();
	//存储配置文件的对象
	FileOutputStream fos = null;
	//读取配置文件的对象
	FileInputStream fis = null;
	@Override
	public void modifyPassword(){
		System.out.println("请输入需要修改密码的用户名：");
		String name = scanner.nextLine();
		try {
			System.out.println(path);
			fis = new FileInputStream(path);
			//读取配置文件中的账号密码，存储在Properties中
			prop.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (prop.getProperty(name) == null) {
			System.out.println("该用户不存在！");
			return;
		}else {
			System.out.println("请输入密码：");
			String pass = scanner.nextLine();
			try {
				prop.replace(name,"user"+" "+name+" "+pass);
				fos = new FileOutputStream(path);
				//将properties中的数据写入文件
				prop.store(fos,null);
				fos.close();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				//关闭流
				System.out.println("Administrator modify userPassword finished!");
			}
		}
	}

	@Override
	public void modifyPassword(String name) throws IOException {
		fis = new FileInputStream(path);
		prop.load(fis);
		fis.close();
		System.out.println("请输入密码：");
		String pass = scanner.nextLine();
		try {
			prop.replace(name,"admin"+" "+name+" "+pass);
			fos = new FileOutputStream(path);
			//将properties中的数据写入文件
			prop.store(fos,null);
			fos.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//关闭流
			System.out.println("Administrator modify adminPassword finished!");
		}
	}
}
