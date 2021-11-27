package cn.patten.strategy;

import cn.patten.bean.DisplayContent;
import cn.patten.bean.ModifyContent;
import cn.patten.bean.ModifyPassword;
import cn.patten.factory.AbstractFactory;
import cn.patten.factory.UserFunFactory;

import java.io.IOException;

public class InitFunctionsForUser implements InitFunctions {

	public void initFunc(String str,String username) throws IOException {

		AbstractFactory f = new UserFunFactory();
		DisplayContent disCont = f.createDisplayContent();
		disCont.displayContent();
		ModifyContent modCont = f.createModifyContent();
		modCont.modifyContent();
		ModifyPassword modPwd = f.createModifyPassword();
		modPwd.modifyPassword(username);

	}
}
