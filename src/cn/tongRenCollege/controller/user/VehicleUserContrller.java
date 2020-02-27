package cn.tongRenCollege.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.tongRenCollege.dao.Base;
import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.dao.mapper.EmployeeMapper;
import cn.tongRenCollege.service.user.VehicleUserService;

@Controller
public class VehicleUserContrller {
	
	@Autowired
	VehicleUserService userService;
	
	@Autowired
	EmployeeMapper empMapper;
	
	
	/**
	 * 首页请求url,返回最新的前x条信息
	 * @param x
	 * @return
	 */
	@RequestMapping("/userQueryVehicleNew/{x}")
	@ResponseBody
	public List<VehicleFull> queryVehicleFull(@PathVariable("x")int x){
		return userService.queryVehicleFullByNew(x);
	}
	
	
	
	/**
	 * 查询一辆车辆数据,
	 * @param x 车辆的id
	 * @return
	 */
	@RequestMapping("/details/{id}")
	public ModelAndView vehicleDetails(@PathVariable("id")String x){
		ModelAndView md = new ModelAndView();
		md.setViewName("/vehicle_info");
		VehicleFull vlf = userService.vehicleDetails(x);
		md.addObject("vehicle", vlf);//返回该车的详细数据
		md.addObject("employee", empMapper.selectEmployee(vlf.getVehicle_employee_id()));//返回负责员工的信息
		
		return md;
	}
	
	/**
	 * 查询所有车辆数据
	 * @return
	 */
	@RequestMapping("/queryVehicleList")
	public ModelAndView vehicleList(){
		ModelAndView md = new ModelAndView();
		md.setViewName("/vehicle_list");
		List<VehicleFull> vehicleFullAll = userService.queryVehicleFullAll("vehicle_price", "ASC");
		md.addObject("vfs", vehicleFullAll);//返回该车的详细数据
		
		return md;
	}
	
	/**
	 * 条件查询车辆信息
	 * @param vehicle
	 * @return
	 */
	@RequestMapping("/selectVehicleList")
	public ModelAndView selectVehicleList(VehicleFull vehicle){
		ModelAndView md = new ModelAndView();
		md.setViewName("/vehicle_list");
		List<VehicleFull> vehicleFullAll = userService.selectVehicle(vehicle);
		md.addObject("vfs", vehicleFullAll);//返回该车的详细数据
		
		
		Base base=vehicle.getBase();
		if(base != null) {
			if(base.getBase_brand()!=null && !base.getBase_brand().equals("")) {
				md.addObject("brand", vehicle.getBase().getBase_brand());
			}
			if(base.getBase_displacement() != 0) {
				String displacement="";
				if(base.getBase_displacement()<=2) {
					displacement="2L以下";
				}else if(base.getBase_displacement()<=3) {
					displacement="2-3L";
				}else if(base.getBase_displacement()<=5) {
					displacement="3-5L";
				}else {
					displacement="5L以上";
				}
				md.addObject("displacement", displacement);
				
			}
			if(base.getBase_type()!=null && !base.getBase_type().equals("") ) {
				md.addObject("type", vehicle.getBase().getBase_type());
			}
			
		}
		
		if(vehicle.getVehicle_mileage()!=0) {
			String mileage="";
			if(vehicle.getVehicle_mileage()<=1) {
				mileage="1万公里以内";
			}else if(vehicle.getVehicle_mileage()<=3) {
				mileage="3万公里以内";
			}else if(vehicle.getVehicle_mileage()<=5) {
				mileage="5万公里以内";
			}else {
				mileage="5万公里以上";
			}
			
			md.addObject("mileage", mileage);
		}
		if(vehicle.getVehicle_price()!=0) {
			String price="";
			if(vehicle.getVehicle_price()<=200) {
				price="0-200元";
			}else if(vehicle.getVehicle_price()<=500) {
				price="200-500元";
			}else if(vehicle.getVehicle_price()<=1000) {
				price="500-1000元";
			}else {
				price="1000元以上";
			}
			
			md.addObject("price", price);
		}
		
		return md;
	}
		
	
}
