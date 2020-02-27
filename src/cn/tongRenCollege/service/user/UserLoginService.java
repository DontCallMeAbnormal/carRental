package cn.tongRenCollege.service.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.dao.mapper.UserMapper;
import cn.tongRenCollege.util.UUIDCreater;

@Service
public class UserLoginService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	HttpSession session;
	/**
	 * 验证用户
	 * @param user
	 * @return
	 */
	public User testUser(User user) {
		User u = userMapper.getUser(user);
		if(u!=null) {
			u.setUser_pwd(null);
			session.setAttribute("user", u);//设置用户的登录session
		}
		return u;
	}
	
	
	
	
	/**
	 * 用户注册
	 * @return
	 */
	public User registerUser(User user) {
		String uuid = UUIDCreater.getDateID();
		user.setUser_id(uuid);
		userMapper.registerUser(user);
		user.setUser_pwd("");
		session.setAttribute("user", user);
		return user;
	}
	
	
	
}
