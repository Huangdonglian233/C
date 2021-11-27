package cn.patten.factory;

import cn.patten.bean.AdminDisplayContent;
import cn.patten.bean.AdminModifyContent;
import cn.patten.bean.AdminModifyPassword;
import cn.patten.bean.DisplayContent;
import cn.patten.bean.ModifyContent;
import cn.patten.bean.ModifyPassword;

public class AdminFunFactory extends AbstractFactory{

	@Override
	public DisplayContent createDisplayContent() {
		return new AdminDisplayContent();
	}

	@Override
	public ModifyContent createModifyContent() {
		return new AdminModifyContent();
	}

	@Override
	public ModifyPassword createModifyPassword() {
		return new AdminModifyPassword();
	}	
}
