package cn.tongRenCollege.controller.user;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.Orderdetail;
import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.service.user.OrderUserService;

@Controller
public class OrderUserContrller {

	@Autowired
	OrderUserService userService;
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/createrOrder")
	public ModelAndView createOrder(Order order,int dayNum) {
		
		ModelAndView md = new ModelAndView();
		try {
			List<Orderdetail> orders = userService.customerOrders(order, dayNum);
			md.addObject("orders", orders);
			md.setViewName("/userInfo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return md;
	}
	
	
	@RequestMapping("/userInfo")
	public ModelAndView userInfo() {
		ModelAndView md = new ModelAndView();
		try {
			User user = (User)session.getAttribute("user");
			List<Orderdetail> orders = userService.queryOrderdetailList(user.getUser_id());
			md.addObject("orders", orders);
			md.setViewName("/WEB-INF/page/vehicle_user");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return md;
	}
	
	
}
