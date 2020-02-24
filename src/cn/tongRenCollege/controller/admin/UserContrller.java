package cn.tongRenCollege.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.service.admin.UserManagerSerivce;

@Controller
public class UserContrller {

	@Autowired
	UserManagerSerivce userManagerSerivce;
	
	@RequestMapping("/queryUserMssg")
	@ResponseBody
	public List<User> queryUserMssg(){
		List<User> queryUserAllList = userManagerSerivce.queryUserAllList();
		return queryUserAllList;
	}
	
	@RequestMapping("/queryUserTerm")
	@ResponseBody
	public List<User> queryUserTerm(User user){
		List<User> queryUserAllList = userManagerSerivce.queryUsersByTerm(user);
		return queryUserAllList;
	}
	
	
}
