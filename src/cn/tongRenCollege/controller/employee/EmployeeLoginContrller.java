package cn.tongRenCollege.controller.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tongRenCollege.dao.Adm;
import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.service.admin.AdminLoginSerivce;
import cn.tongRenCollege.service.admin.EmployeeManagerService;
import cn.tongRenCollege.service.employee.EmployeeLoginService;

@Controller
public class EmployeeLoginContrller {

	@Autowired
	EmployeeLoginService emploginService;
	
	@Autowired
	HttpSession session;
	
	
	/**
	 * 员工登录
	 * @param Employee emp
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginEmployee")
	@ResponseBody
	public String loginEmployee(Employee emp) {
		
		Employee loginEmp = emploginService.loginEmployee(emp);
		if(loginEmp==null) {
			return "defeat";
		}
		return "success";
	}
	
	/**
	 * 员工登出
	 * @return
	 */
	
	 @RequestMapping("/logoutEmployee")
	 public String logoutEmployee() {
		 emploginService.logoutEmployee();
		 return "redirect:/backgroundLogin.html"; 
	 }
	 
	 
		/**
		 * 员工信息
		 * 
		 */
		 @RequestMapping("/getEmployeeInfo")
		 @ResponseBody
		 public Employee getEmployeeInfo() {
			Employee emp = (Employee)session.getAttribute("emp");
			if(emp==null) {
				emp=new Employee();
				emp.setEmployee_name("未登录");
			}
			emp.setEmployee_pwd(" ");
			return emp; 
		 }	
	
	
}
