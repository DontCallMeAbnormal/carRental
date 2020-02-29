package cn.tongRenCollege.service.user;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tongRenCollege.dao.Base;
import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.Orderdetail;
import cn.tongRenCollege.dao.Vehicle;
import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.dao.mapper.AdmMapper;
import cn.tongRenCollege.dao.mapper.UserMapper;
import cn.tongRenCollege.model.OrderModel;
import cn.tongRenCollege.util.PhotoPathTranslation;

@Service
public class OrderUserService implements OrderModel{

	@Autowired
	UserMapper userMapper;
	@Autowired
	AdmMapper admMapper;
	@Autowired
	PhotoPathTranslation ppt;
	
	
	
	
	/**
	 * 用户端创建订单,并返回用户当前的所有订单
	 * @param order
	 * @param dayNum
	 * @return
	 * @throws Exception
	 */
	public List<Orderdetail> customerOrders(Order order,int dayNum) throws Exception{
		createrOrder(order, dayNum);//先添加订单
		return queryOrderdetailList(order.getOrder_user_id());//返回用户的所有订单信息
	}
	
	
	/**
	 * 根据用户id查询
	 * @param user_id
	 * @return
	 */
	public List<Orderdetail> queryOrderdetailList(String user_id){
		Orderdetail orderdetail = new Orderdetail();
		orderdetail.setOrder_user_id(user_id);
		return queryOrderdetailList(orderdetail);
	}
	
	
	@Override
	public List<Orderdetail> queryOrderdetailList(Orderdetail orderdetail) {
		// TODO Auto-generated method stub

		List<Orderdetail> queryOrderDetail = admMapper.queryOrderDetail(orderdetail);
		
		//变换订单里的图片路径
		VehicleFull vehicleFull;
		Base translation;
		for (Orderdetail order : queryOrderDetail) {
			vehicleFull = order.getVehicleFull();
			translation = ppt.baseTranslation(vehicleFull.getBase());
			vehicleFull.setBase(translation);
			order.setVehicleFull(vehicleFull);
		}
		return queryOrderDetail;
	}

	
	
	
	
	@Override
	public void updata(Order order) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void createrOrder(Order order,int dayNum) throws Exception{
		// TODO Auto-generated method stub
		Date startDate = order.getOrder_startDate();
		
		Date today= new Date(System.currentTimeMillis());
		today.setDate(today.getDate()-1);
		
		boolean after = startDate.after(today);//判断是否在今天之后
		if(!after) {
			throw new RuntimeException("取车日期必须是今天之后");
		}
		
		Date stopDate = new Date(startDate.getTime());
		stopDate.setDate(stopDate.getDate()+dayNum);
		
		System.out.println("=======================");
		System.out.println("======== "+order+"    =====");
		System.out.println("=======================");
		VehicleFull vehicleFull = userMapper.getVehicleFullById(order.getOrder_vehicle_id());
		
		order.setOrder_price(vehicleFull.getVehicle_price()*dayNum);//计算价格
		order.setOrder_stopDate(stopDate);//设置订单stopDate日期
		order.setOrder_quantity((short) dayNum);
		createrOrder(order);
		
	}


	@Override
	public void createrOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		
		order.setOrder_state("预订单");//设置状态
		order.setOrder_id(new java.util.Date());//设置订单的id
		if(!changeState("已出租", order.getOrder_vehicle_id())) {
			System.out.println("=======================");
			System.out.println("======== 车已经被租出    =====");
			System.out.println("=======================");
			return;
		}
		System.out.println("=======================");
		System.out.println("=======   创建订单     =======");
		System.out.println("=======================");
		
		userMapper.creatOrder(order);
		
		
	}
	
	
	
	/**
	 * 修改车辆的状态,成返回true,失败返回false
	 * @param state
	 * @param vehicle_id
	 */
	private Boolean changeState(String state,String vehicle_id) {
		VehicleFull vehicleFull = admMapper.getVehicleFullById(vehicle_id);
		String vehicle_state = vehicleFull.getVehicle_state();
		System.out.println("=======================");
		System.out.println("数据库的车辆的状态  :"+vehicle_state);
		System.out.println("数据库的车辆的id  :"+vehicleFull.getVehicle_id());
		System.out.println("=======================");
		if(vehicle_state.equals(state)) {
			return false;
		}
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicle_id(vehicle_id);
		vehicle.setVehicle_state(state);
		admMapper.updataVehicle(vehicle);
		return true;
			
	}
	
	

	
	
}
