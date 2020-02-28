package cn.tongRenCollege.service.employee;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.Orderdetail;
import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.dao.mapper.EmployeeMapper;
import cn.tongRenCollege.dao.mapper.UserMapper;
import cn.tongRenCollege.model.OrderModel;

@Service
public class OrderEmployeeService implements OrderModel{

	@Autowired
	HttpSession session;
	@Autowired
	EmployeeMapper empMapper;
	@Autowired
	UserMapper userMapper;
	
	/**
	 * 查询该员工拥有的订购单
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<Orderdetail> queryOrderdetail(){
		Employee emp = (Employee) session.getAttribute("emp");
		
		if(emp==null) {
			return null;
		}
		
		return empMapper.queryOrderDetail(emp.getEmployee_id());
		
	}
	
	
	/**
	 * 条件查询该员工的订单
	 */
	@Transactional(readOnly=true)
	public List<Orderdetail> queryOrderdetailList(Orderdetail orderdetail){
		Employee emp = (Employee) session.getAttribute("emp");
		
		if(emp==null) {
			return null;
		}
		
		return empMapper.queryOrderDetailTerm(orderdetail);
		
	}

	
	/**
	 * 员工的订单修改方法,员工需要输入用户的电话和密码,进行校验才能修改订单
	 * 且 仅能修改订单的还车日期和订单的状态
	 * @param order
	 * @param user
	 * @throws Exception
	 */
	@Transactional
	public void updataOrder(Order order,User user) throws Exception{
		Employee emp = (Employee) session.getAttribute("emp");
		
		if(emp==null) {
			throw new Exception("管理员未登录");
		}
		
		user = userMapper.getUser(user);
		if(user==null) {
			throw new Exception("用户密码错误");
		}
		
		
		updata(order);
				
	}
	
	

	@Override
	public void updata(Order order) throws Exception {
		// TODO Auto-generated method stub
		
		if(order.getOrder_state().equals("实订单") || order.getOrder_state().equals("预订单") || order.getOrder_state().equals("完成订单")) {
			empMapper.updateOrder(order);
		}else {
			throw new Exception("订单类型错误");
		}
		
	}


	@Override
	public void createrOrder(Order order) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createrOrder(Order order, int dayNum) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
