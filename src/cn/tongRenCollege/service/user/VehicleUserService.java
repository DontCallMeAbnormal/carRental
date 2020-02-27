package cn.tongRenCollege.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.dao.mapper.UserMapper;
import cn.tongRenCollege.util.PhotoPathTranslation;

@Service
public class VehicleUserService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PhotoPathTranslation ppt;
	
	
	
	/**
	 * 返回所有车辆的记录
	 * @param colName 排序的根据字段
	 * @param DescAsc 升序或降序 (DESC|ASC)
	 * @return
	 */
	public List<VehicleFull> queryVehicleFullAll(String colName,String DescAsc){
		List<VehicleFull> vehicleFullAll = userMapper.queryVehicleFullAll(colName, DescAsc);
		return ppt.vehicleFulltranslation(vehicleFullAll);
	}
	
	
	
	
	/**
	 * 返回最新的x条记录
	 * @param x
	 * @return
	 */
	public List<VehicleFull> queryVehicleFullByNew(int x){
		return ppt.vehicleFulltranslation(userMapper.queryVehicleFullByNewNum(x));
	}
	
	
	/**
	 *	 获取指定id的车辆的详细数据
	 * @param id
	 * @return
	 */
	public VehicleFull vehicleDetails(String id) {
		VehicleFull vlf=userMapper.getVehicleFullById(id);
		vlf.setBase(ppt.baseTranslation(vlf.getBase()));
		return vlf;
	}
	
	
	/**
	 * 条件查询车辆信息
	 * @return
	 */
	public List<VehicleFull> selectVehicle(VehicleFull vehicleFull){
		List<VehicleFull> queryVehicleFull = userMapper.queryVehicleFull(vehicleFull);
		
		return ppt.vehicleFulltranslation(queryVehicleFull);
	}
	
	
	
	
	
}
