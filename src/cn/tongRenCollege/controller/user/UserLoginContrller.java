package cn.tongRenCollege.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.service.user.UserLoginService;

@Controller
public class UserLoginContrller {

	
	@Autowired
	UserLoginService userSvice;
	@Autowired
	HttpSession session;
	
	@RequestMapping("/loginUser")
	@ResponseBody
	public User userlogin(User user) {
		User u = userSvice.testUser(user);
		return u;
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUserInfo() {
		User u = (User) session.getAttribute("user");
		return u;
	}
	
}
