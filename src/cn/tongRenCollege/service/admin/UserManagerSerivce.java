package cn.tongRenCollege.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.dao.mapper.AdmMapper;

@Service
public class UserManagerSerivce {
	
	@Autowired
	AdmMapper admMapper;
	
	
	/**
	 * 查询所有用户服务方法
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<User> queryUserAllList(){
		
		List<User> queryUsers = admMapper.queryUsers();
		return queryUsers;
	}
	
	/**
	 * 条件查询用户服务方法
	 * @param user
	 * @return
	 */
	public List<User> queryUsersByTerm(User user){
		List<User> queryUserByUser = admMapper.queryUserByUser(user);
		return queryUserByUser;
	}
	
	
}
