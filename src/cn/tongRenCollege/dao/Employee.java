package cn.tongRenCollege.dao;
/**
 * 	employee _id		varchar		工号
	employee _name		varchar		用户名
	employee _ phone	varchar		电话
	employee _pwd		varchar		密码
	employee _state		varchar		状态  (在岗/下班)
 * @author Administrator
 *
 */
public class Employee {
	private String employee_id;
	private String employee_name;
	private String employee_phone;
	private String employee_pwd;
	private String employee_state;
	
	public String getEmployee_state() {
		return employee_state;
	}
	public void setEmployee_state(String employee_state) {
		this.employee_state = employee_state;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_phone() {
		return employee_phone;
	}
	public void setEmployee_phone(String employee_phone) {
		this.employee_phone = employee_phone;
	}
	public String getEmployee_pwd() {
		return employee_pwd;
	}
	public void setEmployee_pwd(String employee_pwd) {
		this.employee_pwd = employee_pwd;
	}
	@Override
	public String toString() {
		return "{\"employee_id\":\"" + employee_id + "\",\"employee_name\":\"" + employee_name
				+ "\",\"employee_phone\":\"" + employee_phone + "\",\"employee_pwd\":\"" + employee_pwd
				+ "\",\"employee_state\":\"" + employee_state + "\"}";
	}
	
	
	
}
