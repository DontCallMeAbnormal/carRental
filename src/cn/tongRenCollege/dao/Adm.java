package cn.tongRenCollege.dao;
/**
 * 	adm _id		varchar		Id标识
	adm _name	varchar		用户名
	adm _ phone	varchar		电话
	adm _pwd	varchar		密码

 * @author Administrator
 *
 */
public class Adm {
	private String adm_id;
	private String adm_name;
	private String adm_phone;
	private String adm_pwd;
	public String getAdm_id() {
		return adm_id;
	}
	public void setAdm_id(String adm_id) {
		this.adm_id = adm_id;
	}
	public String getAdm_name() {
		return adm_name;
	}
	public void setAdm_name(String adm_name) {
		this.adm_name = adm_name;
	}
	public String getAdm_phone() {
		return adm_phone;
	}
	public void setAdm_phone(String adm_phone) {
		this.adm_phone = adm_phone;
	}
	public String getAdm_pwd() {
		return adm_pwd;
	}
	public void setAdm_pwd(String adm_pwd) {
		this.adm_pwd = adm_pwd;
	}
	@Override
	public String toString() {
		return "{\"adm_id\":\"" + adm_id + "\",\"adm_name\":\"" + adm_name + "\",\"adm_phone\":\"" + adm_phone
				+ "\",\"adm_pwd\":\"" + adm_pwd + "\"}";
	}
	
	
	
}
