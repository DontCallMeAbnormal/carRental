package cn.tongRenCollege.dao;

public class Orderdetail extends Order{
	private User user;
	private VehicleFull vehicleFull;
	private Employee employee;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public VehicleFull getVehicleFull() {
		return vehicleFull;
	}
	public void setVehicleFull(VehicleFull vehicleFull) {
		this.vehicleFull = vehicleFull;
	}
	@Override
	public String toString() {
		return "{\"user\":\"" + user + "\",\"vehicleFull\":\"" + vehicleFull + "\",\"employee\":\"" + employee
				+ "\",\"toString()\":\"" + super.toString() + "\"}";
	}
	
	
	
	
}
