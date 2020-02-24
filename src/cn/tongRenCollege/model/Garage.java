package cn.tongRenCollege.model;

import java.util.List;

import cn.tongRenCollege.dao.Vehicle;
import cn.tongRenCollege.dao.VehicleFull;

/**
 * 车库系统
 * @author Administrator
 *
 */
public interface Garage {
	
	/**
	 * 增加车辆到车库
	 * @param vehicle
	 * @throws Exception
	 */
	public void addVehicle(Vehicle vehicle) throws Exception;
	
	/**
	 * 更新车辆信息
	 * @param vehicle
	 * @throws Exception
	 */
	public void updataVehicle(Vehicle vehicle) throws Exception;
	
	/**
	 * 从车库删除车辆
	 * @param vehicleId
	 * @throws Exception
	 */
	public void deleteVehicle(String vehicleId) throws Exception;
	
	
	/**
	 * 查询车辆
	 * @param vehicle
	 * @return VehicleFull列表
	 * @throws Exception 
	 */
	public List<VehicleFull> queryVehicle(VehicleFull vehicle) throws Exception;
	
	
}
