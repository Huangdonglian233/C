package cn.patten.common;

import java.util.Scanner;

import cn.patten.bean.User;
import cn.patten.strategy.InitStrategy;

public class ProMain {

	public static void main(String[] args) {
		String userName = null;
		String password = null;
		ValidateUserInfo vdUser = new ValidateUserInfo();	

		Scanner reader = new Scanner(System.in);
		userName = reader.next();
		password = reader.next();
		User user = vdUser.validate(userName, password);
		if (user.getUserType() == null) {
			System.out.println("Validated fail!");
			return;
		}
		
		InitStrategy initf = new InitStrategy();
		initf.Init(user.getUserType(),userName);
	}
}
