package cn.tongRenCollege.service.employee;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.dao.Vehicle;
import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.dao.mapper.EmployeeMapper;
import cn.tongRenCollege.model.Garage;
import cn.tongRenCollege.util.PhotoPathTranslation;

@Service
public class VehicleEmployeeService implements Garage{

	@Autowired
	EmployeeMapper empMapper;
	@Autowired
	HttpSession session;
	@Autowired
	PhotoPathTranslation pption;
	
	@Override
	public void addVehicle(Vehicle vehicle) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updataVehicle(Vehicle vehicle) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVehicle(String vehicleId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * 查询该员工所管理的车辆
	 * @throws Exception 
	 */
	@Override
	public List<VehicleFull> queryVehicle(VehicleFull vehicle){
		// TODO Auto-generated method stub
		Employee emp = (Employee)session.getAttribute("emp");
		if(emp==null) {
			return null;
		}
		vehicle.setVehicle_employee_id(emp.getEmployee_id());
		//转换图片路径
		List<VehicleFull> vehicleFulltranslation = pption.vehicleFulltranslation(empMapper.queryVehicleFull(vehicle));
		return vehicleFulltranslation;
	}

	
	
	
	
}
