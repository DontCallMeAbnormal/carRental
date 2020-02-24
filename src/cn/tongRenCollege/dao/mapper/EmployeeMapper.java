package cn.tongRenCollege.dao.mapper;

import java.sql.Date;
import java.util.List;

import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.Orderdetail;
import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.dao.VehicleFull;

public interface EmployeeMapper {
	
	/**
	 * 输入id或电话号码  和 密码进行员工校验
	 * @return Employee
	 */
	public Employee getEmployee(String idOrNumber,String password);
	
	/**
	 * 上班打卡,修改状态为在岗
	 * @param employee_id
	 */
	public void ClockInEmployee(String employee_id);
	
	
	/**
	 * 下班打卡,修改状态为下班
	 * @param employee_id
	 */
	public void ClockOutEmployee(String employee_id);
	
	
	/**
	 * 根据Id查询用户信息
	 * @param id
	 * @return User
	 */
	public User getUserById(String id);
	
	/**
	 * 根据用户名查找
	 * @param userName
	 * @return User集合
	 */
	public List<User> queryUserByName(String userName);
	
	/**
	 * 根据电话号码查询
	 * @param phoneNumber
	 * @return User
	 */
	public User getUserByPhone(String phoneNumber);
	
	
	/**
	 * 根据员工Id查询该员工的订单
	 * @param employeeId
	 * @return
	 */
	public List<Order> queryOrders(String employeeId);
	

	/**
	 * 根据员工Id查询该员工的订单详细
	 * @param employeeId
	 * @return
	 */
	public List<Orderdetail> queryOrderDetail(String employeeId);
	
	/**
	 * 条件查询订单
	 * @param orderdetail
	 * @return
	 */
	public List<Orderdetail> queryOrderDetailTerm(Orderdetail orderdetail);
	
	/**
	 * 根据车牌号查询车辆的所有信息
	 * @return VehicleFull
	 */
	public VehicleFull getVehicleFullById(String id);
	
	/**
	 * 多个条件查询,查询满足条件的车辆完整信息
	 * @param vehicleFull
	 * @return	VehicleFull集合
	 */
	public List<VehicleFull> queryVehicleFull(VehicleFull vehicleFull);
	
	/**
	 * 查询所有库中车辆
	 * @param colName 排序的字段
	 * @param DescAsc DESC降序/ASC升序
	 * @return
	 */
	public List<VehicleFull> queryVehicleFullAll(String colName,String DescAsc);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 根据订单Id号确认订单,改变订单的状态为实订单
	 * @param id
	 */
	public void certifyOrder(java.util.Date orderId);
	
	/**
	 * 根据订单id修改订单的状态为实订单
	 * @param orderId
	 * @param finishDate
	 */
	public void finishOrder(java.util.Date orderId,java.sql.Date finishDate);
	
	/**
	 * 将参数中的信息 覆盖到数据库中,参数对象的id不能为空,空属性不会讲数据库覆盖
	 * @param newOrder
	 */
	public void updateOrder(Order newOrder);
	
}
