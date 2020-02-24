package cn.tongRenCollege.dao;
/**
 * 	Vehicle _id				varchar		车辆库号Id标识
	Vehicle _ base _id		varchar		车辆基础信息id
	Vehicle _employee _id	varchar		负责员工
	Vehicle _price			number		车辆价格/天
	Vehicle _describe		varchar		车辆描述
	Vehicle _mileage		number		里程(万公里)
	Vehicle _condition		number		车辆状况(新旧程度)
	Vehicle _ state			varchar		车辆状态(已出租/空闲/其他)

	车辆状态:约束(已出租;空闲;其他)
	车辆状况:约束(1-9)
 * 
 * @author Administrator
 *
 */
public class Vehicle {
	private String	vehicle_id;
	private String	vehicle_base_id;
	private String	vehicle_employee_id;
	private double	vehicle_price;	
	private String	vehicle_describe;
	private double	vehicle_mileage;
	private short	vehicle_condition;
	private String	vehicle_state;
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getVehicle_base_id() {
		return vehicle_base_id;
	}
	public void setVehicle_base_id(String vehicle_base_id) {
		this.vehicle_base_id = vehicle_base_id;
	}
	public String getVehicle_employee_id() {
		return vehicle_employee_id;
	}
	public void setVehicle_employee_id(String vehicle_employee_id) {
		this.vehicle_employee_id = vehicle_employee_id;
	}
	public double getVehicle_price() {
		return vehicle_price;
	}
	public void setVehicle_price(double vehicle_price) {
		this.vehicle_price = vehicle_price;
	}
	public String getVehicle_describe() {
		return vehicle_describe;
	}
	public void setVehicle_describe(String vehicle_describe) {
		this.vehicle_describe = vehicle_describe;
	}
	public double getVehicle_mileage() {
		return vehicle_mileage;
	}
	public void setVehicle_mileage(double vehicle_mileage) {
		this.vehicle_mileage = vehicle_mileage;
	}
	public short getVehicle_condition() {
		return vehicle_condition;
	}
	public void setVehicle_condition(short vehicle_condition) {
		this.vehicle_condition = vehicle_condition;
	}
	public String getVehicle_state() {
		return vehicle_state;
	}
	public void setVehicle_state(String vehicle_state) {
		this.vehicle_state = vehicle_state;
	}
	@Override
	public String toString() {
		return "{\"vehicle_id\":\"" + vehicle_id + "\",\"vehicle_base_id\":\"" + vehicle_base_id
				+ "\",\"vehicle_employee_id\":\"" + vehicle_employee_id + "\",\"vehicle_price\":\"" + vehicle_price
				+ "\",\"vehicle_describe\":\"" + vehicle_describe + "\",\"vehicle_mileage\":\"" + vehicle_mileage
				+ "\",\"vehicle_condition\":\"" + vehicle_condition + "\",\"vehicle_state\":\"" + vehicle_state + "\"}";
	}
	
}
