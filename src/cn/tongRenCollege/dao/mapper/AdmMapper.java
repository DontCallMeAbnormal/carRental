package cn.tongRenCollege.dao.mapper;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tongRenCollege.dao.Adm;
import cn.tongRenCollege.dao.Base;
import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.Orderdetail;
import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.dao.Vehicle;
import cn.tongRenCollege.dao.VehicleFull;


public interface AdmMapper {
	public Adm getAdm(Adm adm);
	/**
	 * 向数据库添加员工
	 * @param employee
	 */
	public void addEmployee(Employee employee);
	
	/**
	 * 根据id 删除员工
	 * @param id
	 */
	public void removeEmployeeById(String id);
	
	/**
	 * 根据id删除车辆信息
	 * @param id
	 */
	public void removeBaseById(String id);
	
	/**
	 * 根据id将车辆从库中删除
	 * @param id
	 */
	public void removeVehicleById(String id);
	
	
	/**
	 * 根据id查询员信息
	 * @param id
	 * @return
	 */
	public Employee getEmployeeById(String id);
	
	
	/**
	 * 查询所有员工信息
	 * @return	List<Employee>
	 */
	public List<Employee> queryEmployees();
	
	/**
	 * 多个条件查询员工
	 * @param employee
	 * @return
	 */
	public List<Employee> queryEmployeesByemployee(Employee employee);
	/**
	 * 根据id查找用户
	 * @param id
	 * @return User
	 */
	public User getUserById(String id);
	
	/**
	 * 查询所有用户
	 * @return List<User>
	 */
	public List<User> queryUsers();
	
	/**
	 * 条件查询用户信息
	 * @return
	 */
	public List<User> queryUserByUser(User user);
	
	
	/**
	 * 根据id查询车辆基础信息
	 * @param id
	 * @return
	 */
	public Base getBaseById(String id);
	
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
	 * 查询所有车辆基础信息
	 * @return
	 */
	public List<Base> queryBases();
	
	
	/**
	 * 根据车辆类型查询车辆基础信息
	 * @param type
	 * @return	List<Base>
	 */
	public List<Base> queryBasesByType(String type);
	
	/**
	 * 根据品牌查询车辆信息
	 * @param brand
	 * @return	List<Base>
	 */
	public List<Base> queryBasesByBrand(String brand);
	
	/**
	 * 查询某个时间之后的base信息
	 * @param date
	 * @return List<Base>
	 */
	public List<Base> queryByDateAfter(Date date);
	
	/**
	 * 查询排量最低为diplacement的车辆信息集合
	 * @param diplacement
	 * @return List<Base>
	 */
	public List<Base> queryByDisplacementMin(double diplacement);
	
	/**
	 * 查询排量最高为diplacement的车辆信息集合
	 * @param diplacement
	 * @return List<Base>
	 */
	public List<Base> queryByDisplacementMax(double diplacement);
	
	/**
	 * 查询排量在min 和 max 之间的车辆信息
	 * @param startDate
	 * @param stopDate
	 * @return
	 */
	public List<Base> queryByDisplacement(double min,double max);
	
	/**
	 * 查询速度上限最低为minSpeed的车辆信息
	 * @param minSpeed
	 * @return List<Base>
	 */
	public List<Base> queryBySpeedMin(double minSpeed);
	
	/**
	 * 查询速度上限最高为minSpeed的车辆信息
	 * @param minSpeed
	 * @return List<Base>
	 */
	public List<Base> queryBySpeedMax(double maxSpeed);
	
	/**
	 * 查询速度上线在minSpeed 和 maxSpeed之间的车辆信息
	 * @param minSpeed
	 * @param maxSpaeed
	 * @return	List<Base>
	 */
	public List<Base> queryBySpeed(double minSpeed,double maxSpaeed);
	
	/**
	 * 多个条件查询,查询满足条件的车辆信息
	 * @param base
	 * @return List<Base>
	 */
	public List<Base> queryBase(Base base);
	
	
	/**
	 * 根据时间查询订单
	 * @param id
	 * @return	Order集合
	 */
	public List<Order> queryOrderByDate(java.util.Date date);
	
	/**
	 * 返回某一天的订单
	 * @param date yyyy-MM-dd
	 * @return
	 */
	public List<Order> queryOrderByOneDay(String date);
	
	/**
	 * 条件查询订单详细信息
	 * @param Orderdetail
	 * @return
	 */
	public List<Orderdetail> queryOrderDetail(Orderdetail Orderdetail);
	
	/**
	 * 根据下单用户的id进行查询订单
	 * @param userId
	 * @return	Order集合
	 */
	public List<Order> queryOrderByUserId(String userId);
	
	/**
	 * 根据下单用户的电话查询订单
	 * @param userPhone
	 * @return	Order集合
	 */
	public List<Order> queryOrderByUserPhone(String userPhone);
	/**
	 * 根据员工id号进行查询
	 * @param employeeId
	 * @return	Order集合
	 */
	public List<Order> queryOrderByEmployeeId(String employeeId);
	
	
	
	/**
	 * 修改车辆信息,参数类型为Base,若对象的属性为空时则不修改该属性对应的字段,且id属性不能为空
	 * @param base
	 */
	public void updataBase(Base base);
	
	
	/**
	 * 修改订单,参数类型为Order,若对象的属性为空时则不修改该属性对应的字段,且id属性不能为空
	 * @param order
	 */
	public void updataOrder(Order order);
	
	
	/**
	 * 修改库中车辆信息,若对象的属性为空时则不修改该属性对应的字段,且id属性不能为空
	 * @param vehicle
	 */
	public void updataVehicle(Vehicle vehicle);
	
	
	/**
	 * 修改员工的信息,员工的id不能为空,只修改name,phone
	 * @param employee
	 */
	public void updataEmployee(Employee employee);
	
	
	/**
	 * 添加车辆的基础信息,注意车辆基础信息都是不能为空的
	 * @param base
	 */
	public void addBase(Base base);
	
	/**
	 * 将车辆入库
	 * @param vehicle
	 */
	public void addVehicle(Vehicle vehicle);
	
	
	
}
