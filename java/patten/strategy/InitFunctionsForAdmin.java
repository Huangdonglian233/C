package cn.patten.strategy;

import cn.patten.bean.AdminModifyPassword;
import cn.patten.bean.DisplayContent;
import cn.patten.bean.ModifyContent;
import cn.patten.bean.ModifyPassword;
import cn.patten.factory.AbstractFactory;
import cn.patten.factory.AdminFactory;
import cn.patten.factory.AdminFunFactory;

import java.io.IOException;
import java.util.Scanner;

public class InitFunctionsForAdmin implements InitFunctions {

	public void initFunc(String str,String adminName) throws IOException {

		AbstractFactory f = new AdminFunFactory();
		DisplayContent disCont = f.createDisplayContent();
		disCont.displayContent();
		ModifyContent modCont = f.createModifyContent();
		modCont.modifyContent();
		ModifyPassword modPwd = f.createModifyPassword();
		modPwd.modifyPassword(adminName);
		modPwd.modifyPassword();

		AdminFactory afy = new AdminFactory();
		System.out.println("请输入要添加的用户类型");
		Scanner scanner = new Scanner(System.in);
		String type = scanner.nextLine();
		afy.addAddUserFun().addUser(type);
		afy.addDeleteUserFun().deleteUser();
	}
}
