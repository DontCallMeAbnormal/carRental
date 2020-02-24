package cn.tongRenCollege.dao;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 车辆的基础信息
 * 	base_id				varchar		Id标识
	base _photo			varchar		车辆图片路径
	base _ type			varchar		车型
	base _brand			varchar		品牌
	base _model			varchar		型号
	base _produced		Date		上市时间
	base _displacement	number		排量(L)
	base_speed			double		车速
	
	车型: 约束(SUV;mpv;跑车;面包车;皮卡)
 * @author Administrator
 *
 */
public class Base {
	private String base_id;
	private String base_photo;
	private String base_type;
	private String base_brand;
	private String base_model;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date base_produced;
	private double base_displacement;
	private double base_speed;
	public double getBase_speed() {
		return base_speed;
	}
	public void setBase_speed(double base_speed) {
		this.base_speed = base_speed;
	}
	public String getBase_id() {
		return base_id;
	}
	public void setBase_displacement(double base_displacement) {
		this.base_displacement = base_displacement;
	}
	public void setBase_id(String base_id) {
		this.base_id = base_id;
	}
	public String getBase_photo() {
		return base_photo;
	}
	public void setBase_photo(String base_photo) {
		this.base_photo = base_photo;
	}
	public String getBase_type() {
		return base_type;
	}
	public void setBase_type(String base_type) {
		this.base_type = base_type;
	}
	public String getBase_brand() {
		return base_brand;
	}
	public void setBase_brand(String base_brand) {
		this.base_brand = base_brand;
	}
	public String getBase_model() {
		return base_model;
	}
	public void setBase_model(String base_model) {
		this.base_model = base_model;
	}
	
	public Date getBase_produced() {
		return base_produced;
	}
	public void setBase_produced(Date base_produced) {
		this.base_produced = base_produced;
	}
	public double getBase_displacement() {
		return base_displacement;
	}
	@Override
	public String toString() {
		return "{\"base_id\":\"" + base_id + "\",\"base_photo\":\"" + base_photo + "\",\"base_type\":\"" + base_type
				+ "\",\"base_brand\":\"" + base_brand + "\",\"base_model\":\"" + base_model + "\",\"base_produced\":\""
				+ base_produced + "\",\"base_displacement\":\"" + base_displacement + "\",\"base_speed\":\""
				+ base_speed + "\"}";
	}
	
	
	
	
	
}
