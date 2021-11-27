package cn.patten.bean;

public class User {
	private String userType;
	private String userName;
	private String password;
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"userType='" + userType + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
