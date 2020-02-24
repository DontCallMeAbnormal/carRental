package cn.tongRenCollege.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tongRenCollege.dao.Adm;
import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.service.admin.AdminLoginSerivce;
import cn.tongRenCollege.service.admin.EmployeeManagerService;

@Controller
public class EmployeeContrller {

	@Autowired
	EmployeeManagerService employeeMS;
	@Autowired
	AdminLoginSerivce admlogin;
	
	@Autowired
	HttpSession session;
	
	/**
	 * 查询员工信息contrller
	 * @return
	 */
	@RequestMapping("/queryEmpMssg")
	@ResponseBody
	public List<Employee> getEmployeeMessage() {
		List<Employee> queryEmployeeAll = employeeMS.queryEmployeeAll();
		return queryEmployeeAll;
	}
	
	/**
	 * 删除员工contrller
	 * @param adm
	 * @param id
	 */
	@RequestMapping(value="/deleteEmployee",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteEmployee(HttpSession session,String id) {
		Adm adm = (Adm)session.getAttribute("adm");
		
		try {
			employeeMS.deleteEmployeeById(id, adm);
			
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
	/**
	 * 更新员工contrller
	 * @param adm
	 * @param id
	 */
	@RequestMapping(value="/updataEmployee",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updataEmployee(Employee employee) {
		Adm adm=(Adm)session.getAttribute("adm");
		try {
			employeeMS.updataEmployee(employee, adm);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	
	/**
	 * 新增员工
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/addEmployee",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addEmployee(Employee employee) {
		Adm adm=(Adm)session.getAttribute("adm");
		try {
			employeeMS.addEmployee(employee, adm);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	
	
	
	
	/**
	 * 条件查询员工信息
	 * @param employee
	 * @return
	 */
	@RequestMapping("/queryEmployeeTerm")
	@ResponseBody
	public List<Employee> queryEmployeeTerm(Employee employee){
			
		return employeeMS.queryEmployeeTerm(employee);
	}
	
}
