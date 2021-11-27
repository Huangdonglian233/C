package cn.patten.bean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class DeleteUser {

	public void deleteUser(){
		System.out.println("请输入要删除的用户名：");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		String  path = "C:/Users/强联/Desktop/PattensPro/src/cn/patten/singleton/connection.properties";
		Properties prop = new Properties();
		//存储配置文件的对象
		FileOutputStream fos = null;
		//读取配置文件的对象
		FileInputStream fis = null;
		try {
			System.out.println(path);
			fis = new FileInputStream(path);
			//读取配置文件中的账号密码，存储在Properties中
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (prop.getProperty(name) == null) {
			System.out.println("该用户不存在！无法删除");
			return;
		}else {
			try {
				prop.remove(name);
				fos = new FileOutputStream(path);
				//将properties中的数据写入文件
				prop.store(fos,null);
				return;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				//关闭流
				closeStream(fis, fos);
				System.out.println("Administrator delete a user account!");
			}
		}
		
	}

	private void closeStream(FileInputStream fis, FileOutputStream fos) {
	}
}
