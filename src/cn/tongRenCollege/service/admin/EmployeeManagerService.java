package cn.tongRenCollege.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tongRenCollege.dao.Adm;
import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.dao.mapper.AdmMapper;
import cn.tongRenCollege.util.UUIDCreater;

@Service
@Transactional
public class EmployeeManagerService {
	
	@Autowired
	private AdmMapper admMapper;
	
	
	/**
	 * 查询所有员信息,事务只读
	 * @return Employee集合
	 */
	@Transactional(readOnly=true)
	public List<Employee> queryEmployeeAll() {
		List<Employee> queryEmployees = admMapper.queryEmployees();
		return queryEmployees;
	}
	
	
	/**
	 * 根据员工id删除员工
	 * 需要验证管理员信息才可以进行删除操作
	 * @param id
	 * @throws Exception 
	 */
	@Transactional
	public void deleteEmployeeById(String id,Adm adm) throws Exception {
		if(adm==null) {
			throw new Exception("管理员未登录");
		}
		admMapper.removeEmployeeById(id);
	}
	
	
	@Transactional
	public void updataEmployee(Employee employee,Adm adm) throws Exception {
		if(adm==null) {
			throw new Exception("管理员未登录");
		}
		admMapper.updataEmployee(employee);
	}

	
	@Transactional
	public void addEmployee(Employee employee,Adm adm) throws Exception {
		if(adm==null) {
			throw new Exception("管理员未登录");
		}
		if(employee.getEmployee_name().equals("") || employee.getEmployee_phone().equals("") || employee.getEmployee_pwd().equals("")) {
			throw new Exception("请填写完整表单");
		}
		employee.setEmployee_id(UUIDCreater.getDateID());
		employee.setEmployee_state("下班");
		admMapper.addEmployee(employee);
		
	}
	
	
	@Transactional(readOnly=true)
	public List<Employee> queryEmployeeTerm(Employee employee){
		return admMapper.queryEmployeesByemployee(employee);
	}
	
	
}
