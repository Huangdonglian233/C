package cn.patten.factory;

import cn.patten.bean.DisplayContent;
import cn.patten.bean.ModifyContent;
import cn.patten.bean.ModifyPassword;
import cn.patten.bean.UserDisplayContent;
import cn.patten.bean.UserModifyContent;
import cn.patten.bean.UserModifyPassword;

public class UserFunFactory extends AbstractFactory {
	public UserDisplayContent addDisplayContentFun() {
		return new UserDisplayContent();
	}

	public UserModifyPassword addModifyPasswordFun() {
		return new UserModifyPassword();
	}

	@Override
	public DisplayContent createDisplayContent() {
		return new UserDisplayContent();
	}

	@Override
	public ModifyContent createModifyContent() {
		return new UserModifyContent();
	}

	@Override
	public ModifyPassword createModifyPassword() {
		return new UserModifyPassword();
	}
}
