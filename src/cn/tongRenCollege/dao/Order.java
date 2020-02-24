package cn.tongRenCollege.dao;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 	order _id				timestamp	Id标识
	order _vehicle_id		varchar		车辆号Id
	order_user_id			varchar		用户信息id
	order _price			number		订单金额
	order _ state			varchar		订单状态
	(预订单/实订单/完成订单)
	order_startDate			Date		开始日期
	order_ quantity			number		订购天数
	order_ stopDate			Date		完成日期

订单状态order _state: 约束(预订单/实订单/完成订单)
 * @author Administrator
 *
 */
public class Order {
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date order_id;
	private String order_vehicle_id;
	private String order_user_id;
	private double order_price;
	private String order_state;
	@JsonFormat(pattern="yyyy-MM-dd")
	private java.sql.Date order_startDate;
	private short order_quantity;
	@JsonFormat(pattern="yyyy-MM-dd")
	private java.sql.Date order_stopDate;
	public Date getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Date order_id) {
		this.order_id = order_id;
	}
	public String getOrder_vehicle_id() {
		return order_vehicle_id;
	}
	public void setOrder_vehicle_id(String order_vehicle_id) {
		this.order_vehicle_id = order_vehicle_id;
	}
	public String getOrder_user_id() {
		return order_user_id;
	}
	public void setOrder_user_id(String order_user_id) {
		this.order_user_id = order_user_id;
	}
	public double getOrder_price() {
		return order_price;
	}
	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public java.sql.Date getOrder_startDate() {
		return order_startDate;
	}
	public void setOrder_startDate(java.sql.Date order_startDate) {
		this.order_startDate = order_startDate;
	}
	public short getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(short order_quantity) {
		this.order_quantity = order_quantity;
	}
	public java.sql.Date getOrder_stopDate() {
		return order_stopDate;
	}
	public void setOrder_stopDate(java.sql.Date order_stopDate) {
		this.order_stopDate = order_stopDate;
	}
	@Override
	public String toString() {
		return "{\"order_id\":\"" + order_id + "\",\"order_vehicle_id\":\"" + order_vehicle_id
				+ "\",\"order_user_id\":\"" + order_user_id + "\",\"order_price\":\"" + order_price
				+ "\",\"order_state\":\"" + order_state + "\",\"order_startDate\":\"" + order_startDate
				+ "\",\"order_quantity\":\"" + order_quantity + "\",\"order_stopDate\":\"" + order_stopDate + "\"}";
	}
	
	
	
	
}
