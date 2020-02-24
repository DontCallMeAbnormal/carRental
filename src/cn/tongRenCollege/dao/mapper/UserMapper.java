package cn.tongRenCollege.dao.mapper;

import java.util.List;

import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.dao.VehicleFull;

public interface UserMapper {

	/**
	 * 将订单对象当参数传入创建订单
	 * @param order
	 */
	public void creatOrder(Order order);
	
	
	/**
	 * 	用户修改订单, 仅能修改车牌,金额,开始时间,订购天数
	 * 	修改需要改用户的id避免误操作
	 * @param order
	 * @param userId
	 */
	public void updataOrder(Order order);
	
	
	/**
	 * 输入订单号,和用户号, 将对应订单删除
	 * @param orderId
	 * @param userId
	 */
	public void deleteOrder(String orderId,String userId);
	
	
	
	
	
	/**
	 * 输入用户Id 查询该用户的所有订单
	 * @param userId
	 * @return	Order集合
	 */
	public List<Order> queryOrderHistory(String userId);
	
	
	/**
	 * 	条件查找  仅支持
	 * 	 	订单Id/车牌号/金额/订单状态/开始日期
	 * 	查找
	 * @param order
	 * @return
	 */
	public List<Order> queryOrderByorder(Order order);
	
	
	/**
	 * 	检查登录用户名或电话  和 密码 进行校验
	 * @param user
	 * @return
	 */
	public User getUser(User user);
	
	/**
	 * 查询所有库中车辆
	 * @param colName 排序的字段
	 * @param DescAsc DESC降序/ASC升序
	 * @return
	 */
	public List<VehicleFull> queryVehicleFullAll(String colName,String DescAsc);
	
}
