package cn.tongRenCollege.controller.employee;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.Orderdetail;
import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.service.employee.OrderEmployeeService;

@Controller
public class OrderEmployeeContrller {

	@Autowired
	OrderEmployeeService orderService;
	
	/**
	 * 获取员工的订单
	 * @return
	 */
	@RequestMapping("/queryOrderdetailEmp")
	@ResponseBody
	public List<Orderdetail> queryOrderdetailEmp(){
		
		return orderService.queryOrderdetail();
	}
	
	
	/** 
	 * 条件查询控制器
	 * @param order
	 * @param user
	 * @return
	 */
	@RequestMapping("/queryOrderdetailEmpTerm")
	@ResponseBody
	public List<Orderdetail> queryOrderdetailEmpTerm(Orderdetail order,User user){
		if(user != null) {
			order.setUser(user);
		}
		return orderService.queryOrderdetailList(order);
	}
	
	
	@RequestMapping(value="/updataOrderEmp",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updataOrderEmp(Order order,User user) {
		
		try {
			orderService.updataOrder(order, user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}

		return "success";
	}
	
	
	
	
	
}
