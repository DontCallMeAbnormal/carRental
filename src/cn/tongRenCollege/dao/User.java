package cn.tongRenCollege.dao;
/**
 * 	user _id	varchar		Id标识
	user_name	varchar		用户名
	user_ phone	varchar		电话
	user_pwd	varchar		密码

登录时使用电话号码,和密码登录
注册时,需要通过电话号码注册

 * @author Administrator
 *
 */
public class User {
	private String user_id;
	private String user_name;
	private String user_phone;
	private String user_pwd;
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	@Override
	public String toString() {
		return "{\"user_id\":\"" + user_id + "\",\"user_name\":\"" + user_name + "\",\"user_phone\":\"" + user_phone
				+ "\",\"user_pwd\":\"" + user_pwd + "\"}";
	}
	
	
}
