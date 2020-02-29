package cn.tongRenCollege.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tongRenCollege.dao.Orderdetail;
import cn.tongRenCollege.service.admin.OrderManagerService;

@Controller
public class OrderContrller {

	@Autowired
	OrderManagerService orderManagerService;
	@Autowired
	HttpSession httpSession;
	
	/**
	 * 订单条件查询控制器
	 * @param orderdetail
	 * @return
	 */
	@RequestMapping("/queryOrderdetailTerm")
	@ResponseBody
	public List<Orderdetail> queryOrderdetailTerm(Orderdetail orderdetail) {
		List<Orderdetail> orderdetailList = orderManagerService.queryOrderdetailList(orderdetail);
		return orderdetailList;
	}
	
	/**
	 * 查询所有订单
	 * @param orderdetail
	 * @return
	 */
	@RequestMapping("/queryOrderdetail")
	@ResponseBody
	public List<Orderdetail> queryOrderdetail() {
		List<Orderdetail> orderdetailList = orderManagerService.queryOrderdetailList(null);
		return orderdetailList;
	}
	
	
	/**
	 * 返回最近七天的订单数量
	 * @return
	 */
	@RequestMapping(value="/getChartData",method=RequestMethod.GET)
	@ResponseBody
	public int[] getChartData() {
		
		return orderManagerService.getChartData();
	}
	
	
	
}
