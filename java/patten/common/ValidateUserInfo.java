package cn.patten.common;

import java.util.Properties;
import java.util.Set;

import cn.patten.bean.User;
import cn.patten.singleton.Connection;

public class ValidateUserInfo {
	private Properties pros;
	private User user = new User();

	public User validate(String userName, String password) {
		pros = Connection.getInstance().getConnectioninfo();
		Set<Object> keySet = pros.keySet();
		for (Object object : keySet) {
			String prosValue = pros.getProperty(object.toString()).toString();
			String[] strArr = prosValue.split(" ");

			if (userName.equalsIgnoreCase(strArr[1])
					&& password.equalsIgnoreCase(strArr[2])) {
				user.setUserType(strArr[0]);
				user.setUserName(strArr[1]);
				user.setPassword(strArr[2]);
				return user;
			}
		}

		if (user.getUserType() == null) {
			System.out.println("Username or password is not correct!" +
					" Please input username and password again!");
		}
		return user;
	}
}
