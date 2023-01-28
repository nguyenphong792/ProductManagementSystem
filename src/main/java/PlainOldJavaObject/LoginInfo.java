package PlainOldJavaObject;

public class LoginInfo {
	private String userName;
	private String password;
	
	public LoginInfo() {
		
	}

	public LoginInfo(String userName, String password) {
		this.userName = userName;
		this.password = password;
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
		return "LoginInfo [userName=" + userName + ", password=" + password +"]";
	}
}
