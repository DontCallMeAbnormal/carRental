package cn.tongRenCollege.test.dao;

import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.dao.mapper.EmployeeMapper;
import cn.tongRenCollege.util.CreatSqlDateByStr;

public class TestEmployeeMapper {
	EmployeeMapper employeeMapper = null;
	SqlSession session =null;
	
	@Test
	public void getUser() throws IOException {
		initSession();
		
		User userById = employeeMapper.getUserByPhone("1214326436");
		System.out.println(userById);
		
		
	}
	
	@Test
	public void updateOrder() throws IOException, ParseException {
		initSession();
		
		Order o=new Order();
		Date d=CreatSqlDateByStr.creatUtilDateByString("2020-01-06 21:28:26");
		
		
		
		o.setOrder_id(d);
		o.setOrder_state("实订单");
		o.setOrder_startDate(CreatSqlDateByStr.creatDateByString("2020-1-8"));
		employeeMapper.updateOrder(o);
		session.commit();
		
	}
	
	
	@Test
	public void getVehicleFull() throws IOException, ParseException{
		initSession();
		
		
		List<VehicleFull> vehicleFullAll = employeeMapper.queryVehicleFullAll("vehicle_price","DESC");
		for (VehicleFull vehicleFull2 : vehicleFullAll) {
			System.out.println(vehicleFull2);
			
		}
		
		
	}
	
	@Test
	public void getEmployee() throws IOException, ParseException{
		initSession();
		Employee employee = employeeMapper.getEmployee("12345", "1234567");
		System.out.println(employee);
		
	}
	
	public void initSession() throws IOException {
		Reader reader = null;
		SqlSessionFactoryBuilder sessionFactoryBuilder = null;;
		SqlSessionFactory sessionFactory = null;;
		reader = Resources.getResourceAsReader("mybatis/mybatisconfig.xml");
		sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		sessionFactory = sessionFactoryBuilder.build(reader);
		session = sessionFactory.openSession();
		employeeMapper = session.getMapper(EmployeeMapper.class);
	}
}
