package cn.patten.bean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class UserModifyPassword extends ModifyPassword {
	String  path = "C:/Users/强联/Desktop/PattensPro/src/cn/patten/singleton/connection.properties";
	Scanner scanner = new Scanner(System.in);
	Properties prop = new Properties();
	//存储配置文件的对象
	FileOutputStream fos = null;
	//读取配置文件的对象
	FileInputStream fis = null;
	@Override
	public void modifyPassword() {
		return;
	}

	@Override
	public void modifyPassword(String name) throws IOException {
		fis = new FileInputStream(path);
		prop.load(fis);
		fis.close();
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
			System.out.println("Administrator modify adminPassword finished!");
		}
		System.out.println("User modify password!");
	}


}
