package cn.patten.factory;

import cn.patten.bean.DisplayContent;
import cn.patten.bean.ModifyContent;
import cn.patten.bean.ModifyPassword;

public abstract class AbstractFactory {
	
	public abstract DisplayContent createDisplayContent();
	public abstract ModifyContent createModifyContent();
	public abstract ModifyPassword createModifyPassword();
}
