package cn.tongRenCollege.service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tongRenCollege.dao.Adm;
import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.dao.mapper.EmployeeMapper;

@Service
public class EmployeeLoginService {

	@Autowired
	EmployeeMapper empMapper;
	
	@Autowired
	HttpSession session;
	
	/**
	 * 员工登录
	 * @param adm
	 * @return
	 */
	@Transactional
	public Employee loginEmployee(Employee emp) {
		Employee emptest = empMapper.getEmployee(emp.getEmployee_id(), emp.getEmployee_pwd());
		if(emptest!=null) {
			emptest.setEmployee_state("在岗");
			empMapper.ClockInEmployee(emp.getEmployee_id());
			session.setAttribute("emp", emptest);
		}
		return emptest;
	}
	
	/**
	 * 员工登出
	 * @param adm
	 * @return
	 */
	@Transactional
	public void logoutEmployee() {
		Employee emp = (Employee)session.getAttribute("emp");
		if(emp!=null) {
			empMapper.ClockOutEmployee(emp.getEmployee_id());
		}
		session.removeAttribute("emp");
	}
	
}
