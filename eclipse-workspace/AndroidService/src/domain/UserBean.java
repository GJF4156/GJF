package domain;

import java.io.Serializable;

/**
 *  * 数据库查询封装对象  * @author 贺兴波  *  
 */
public class UserBean implements Serializable {

	private int id;
	private String username;
	private String password;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}