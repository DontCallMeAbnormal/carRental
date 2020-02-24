package cn.tongRenCollege.test.spring_mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.mapper.AdmMapper;
import cn.tongRenCollege.dao.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationConfiguration.xml")
public class TestSpring_Mybatis {
	
	@Autowired
	AdmMapper admMapper;
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void testAdmMapper(){
		List<Employee> queryEmployees = admMapper.queryEmployees();
		List<Order> queryOrderHistory = userMapper.queryOrderHistory("12345");
		for (Order order : queryOrderHistory) {
			System.out.println(order);
		}
		for (Employee employee : queryEmployees) {
			System.out.println(employee);
		}
		
	}
	
	
}
