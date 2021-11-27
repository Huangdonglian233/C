package cn.patten.factory;

import cn.patten.bean.AddUser;
import cn.patten.bean.DeleteUser;

public class AdminFactory{

	public AddUser addAddUserFun() {
		return new AddUser();
	}

	public DeleteUser addDeleteUserFun() {
		return new DeleteUser();
	}
}