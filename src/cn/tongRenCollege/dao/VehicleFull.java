package cn.tongRenCollege.dao;

public class VehicleFull extends Vehicle{
	private Base base;

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return "{\"base\":\"" + base + "\",\"vehicle\":\"" + super.toString() + "\"}";
	}

	
	
}
