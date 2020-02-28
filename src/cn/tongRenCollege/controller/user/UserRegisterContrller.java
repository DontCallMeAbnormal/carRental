package cn.tongRenCollege.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.service.user.UserLoginService;

@Controller
public class UserRegisterContrller {

	@Autowired
	UserLoginService userService;
	
	@RequestMapping("/registerUser")
	public String registerUser(User user){
		userService.registerUser(user);
		return "index.html";
	}
	
	
}
