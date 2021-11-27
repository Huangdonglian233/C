package cn.patten.bean;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ModifyPassword {

	public abstract void modifyPassword();

	public abstract void modifyPassword(String name) throws IOException;
}
