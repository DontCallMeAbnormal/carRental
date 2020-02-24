package cn.tongRenCollege.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tongRenCollege.dao.Vehicle;
import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.service.admin.VehicleMangerService;

@Controller
public class VehicleContrller {

	@Autowired
	VehicleMangerService vehicleMS;
	
	
	@RequestMapping(value="/addVehicle",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addVehicle(Vehicle vehicle){
		try {
			vehicleMS.addVehicle(vehicle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
		return "success";
	}
	
	
	@RequestMapping("/queryVehicleMssg")
	@ResponseBody
	public List<VehicleFull> queryVehicle(VehicleFull vehcile){
		
		
		return vehicleMS.queryVehicle(vehcile);
	}
	
	
	@RequestMapping(value="/updataVehicle",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updataVehicle(Vehicle vehicle) {
		try {
			vehicleMS.updataVehicle(vehicle);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
		return "success";
	}
	
	
	@RequestMapping(value="/deleteVehicle",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteVehicle(String id) {
		
		try {
			vehicleMS.deleteVehicle(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
		return "success";
	}
	
	
	
}
