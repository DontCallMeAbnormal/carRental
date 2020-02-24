package cn.tongRenCollege.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.service.employee.VehicleEmployeeService;

@Controller
public class VehicleEmployeeContrller {

	@Autowired
	VehicleEmployeeService vehicleService;
	
	@RequestMapping("/queryVehicleMssgEmp")
	@ResponseBody
	public List<VehicleFull> queryListVehicleFull(VehicleFull vehicle){

		return vehicleService.queryVehicle(vehicle);
	}
	
	
	
	
}
