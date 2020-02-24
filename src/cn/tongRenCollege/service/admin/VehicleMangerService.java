package cn.tongRenCollege.service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tongRenCollege.dao.Base;
import cn.tongRenCollege.dao.Vehicle;
import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.dao.mapper.AdmMapper;
import cn.tongRenCollege.model.Garage;
import cn.tongRenCollege.util.CopyPhoto;
import cn.tongRenCollege.util.PhotoPathTranslation;
import cn.tongRenCollege.util.SelvetContext;
import cn.tongRenCollege.util.UUIDCreater;

@Service
public class VehicleMangerService implements Garage{

	@Autowired
	AdmMapper admMapper;
	@Autowired
	HttpSession session;
	@Autowired
	PhotoPathTranslation pption;
	
	@Transactional
	public void addVehicle(Vehicle vehicle) throws Exception{
		testAdm();
		vehicle.setVehicle_id(UUIDCreater.getDateID());
		vehicle.setVehicle_state("空闲");
		admMapper.addVehicle(vehicle);
	}
	
	
	
	@Transactional
	public List<VehicleFull> queryVehicle(VehicleFull vehicle){
		List<VehicleFull> queryVehicleFull = admMapper.queryVehicleFull(vehicle);
		queryVehicleFull = pption.vehicleFulltranslation(queryVehicleFull);
		return queryVehicleFull;
	}


	@Transactional
	public void updataVehicle(Vehicle vehicle) throws Exception {
		// TODO Auto-generated method stub
		testAdm();
		
		admMapper.updataVehicle(vehicle);
		//System.out.println(vehicle);
	}
 	
	
	/**
	 * 删除车库中的车辆
	 * @param vehicleId 车辆的id
	 * @throws Exception 
	 */
	@Transactional
	public void deleteVehicle(String vehicleId) throws Exception {
		// TODO Auto-generated method stub
		testAdm();
		admMapper.removeVehicleById(vehicleId);
	}
	
	
	/**
	 * 检查管理员是否登录,私有方法
	 * @throws Exception
	 */
	private void testAdm() throws Exception {
		if(session.getAttribute("adm")==null) {
			throw new Exception("管理员未登录");
		}
	}



	
}
