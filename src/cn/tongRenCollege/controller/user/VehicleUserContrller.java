package cn.tongRenCollege.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.dao.mapper.EmployeeMapper;
import cn.tongRenCollege.service.user.VehicleUserService;

@Controller
public class VehicleUserContrller {
	
	@Autowired
	VehicleUserService userService;
	
	@Autowired
	EmployeeMapper empMapper;
	
	@RequestMapping("/userQueryVehicleNew/{x}")
	@ResponseBody
	public List<VehicleFull> queryVehicleFull(@PathVariable("x")int x){
		return userService.queryVehicleFullByNew(x);
	}
	
	@RequestMapping("/details/{id}")
	public ModelAndView vehicleDetails(@PathVariable("id")String x){
		ModelAndView md = new ModelAndView();
		md.setViewName("/vehicle_info");
		VehicleFull vlf = userService.vehicleDetails(x);
		md.addObject("vehicle", vlf);//返回该车的详细数据
		md.addObject("employee", empMapper.selectEmployee(vlf.getVehicle_employee_id()));//返回负责员工的信息
		
		return md;
	}
	
	
	@RequestMapping("/queryVehicleList")
	public ModelAndView vehicleList(){
		ModelAndView md = new ModelAndView();
		md.setViewName("/vehicle_list");
		List<VehicleFull> vehicleFullAll = userService.queryVehicleFullAll("vehicle_id", "DESC");
		md.addObject("vfs", vehicleFullAll);//返回该车的详细数据
		
		return md;
	}
	
	
	
}
