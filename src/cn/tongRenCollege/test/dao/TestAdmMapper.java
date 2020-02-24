package cn.tongRenCollege.test.dao;


import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.tongRenCollege.dao.Adm;
import cn.tongRenCollege.dao.Base;
import cn.tongRenCollege.dao.Employee;
import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.Orderdetail;
import cn.tongRenCollege.dao.User;
import cn.tongRenCollege.dao.Vehicle;
import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.dao.mapper.AdmMapper;
import cn.tongRenCollege.util.CreatSqlDateByStr;

public class TestAdmMapper {
	
	AdmMapper admMapper = null;
	SqlSession session =null;
	@Test
	public void testGetAdm() throws IOException{
		initSession();
		Adm adm=new Adm();
		adm.setAdm_name("admin");
		adm.setAdm_pwd("123456");
		Adm adm2 = admMapper.getAdm(adm);
		System.out.println(adm2);
		
	}
	
	@Test
	public void addEmployee() throws IOException {
		initSession();
		Employee employee=new Employee();
		employee.setEmployee_id("12345");
		employee.setEmployee_name("李枳壳");
		employee.setEmployee_phone("15708547401");
		employee.setEmployee_pwd("1234567");
		
		admMapper.addEmployee(employee);
		session.commit();
	}
	
	
	@Test
	public void addBase() throws IOException, ParseException {
		initSession();
		
		Base b=new Base();
		b.setBase_id("123123");
		b.setBase_photo("c:/eqw.jepg");
		b.setBase_type("suv");
		b.setBase_brand("别克");
		b.setBase_model("昂科威");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		java.util.Date date = dateFormat.parse("2016.8.31");
		b.setBase_produced(new Date(date.getTime()));
		b.setBase_displacement(1.5);
		b.setBase_speed(190);
		
		admMapper.addBase(b);
		session.commit();
		
	}
	
	
	
	@Test
	public void rmEmployee() throws IOException {
		initSession();
		Employee employee=new Employee();
		employee.setEmployee_id("12345");
		employee.setEmployee_name("李枳壳");
		employee.setEmployee_phone("15708547401");
		employee.setEmployee_pwd("1234567");
		
		admMapper.removeEmployeeById("12345");
		session.commit();
	}
	
	@Test
	public void rmBase() throws IOException {
		initSession();
		
		admMapper.removeBaseById("654321");
		session.commit();
	}
	
	
	@Test
	public void getEmployee() throws IOException {
		initSession();
		List<Employee> queryEmployees = admMapper.queryEmployees();
				
		for (Employee employee : queryEmployees) {
			System.out.println(employee);
		}
	}
	
	
	@Test
	public void getUser() throws IOException {
		initSession();
		User user = admMapper.getUserById("1342");
				
		System.out.println(user);
		
		
	}
	
	@Test
	public void getBase() throws IOException, ParseException {
		initSession();
		
		Base b=new Base();
		b.setBase_id("123123");
		b.setBase_photo("c:/eqw.jepg");
		b.setBase_type("suv");
		b.setBase_brand("别克");
		b.setBase_model("昂科威");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		java.util.Date date = dateFormat.parse("2016.8.31");
		b.setBase_produced(new Date(date.getTime()));
		b.setBase_displacement(1.5);
		b.setBase_speed(190);
		List<Base> base = admMapper.queryBase(b);
		for (Base base2 : base) {
			System.out.println(base2);
		}
		
		
	}
	
	
	@Test
	public void getOrder() throws IOException , IOException, ParseException{
		initSession();
		int[] ss= new int[7];
		Date date=new Date(System.currentTimeMillis());	
		for (int i = 0; i < ss.length; i++) {
			ss[i]=getOrdercount(date.toString());
			date.setDate(date.getDate()-1);
		}
		System.out.println("["+ss[0]+","+ss[1]+","+ss[2]+","+ss[3]+","+ss[4]+","+ss[5]+","+ss[6]+"]");
		
		//System.out.println(getOrdercount("2020-01-07"));
		
		
	}
	
	public int getOrdercount(String date) {
		List<Order> listOrder = admMapper.queryOrderByOneDay(date);
		System.out.println(listOrder.size());
		return listOrder.size();
	}
	
	@Test
	public void getVehicleFull() throws IOException {
		initSession();
		VehicleFull v=new VehicleFull();
		Base b=new Base();
		b.setBase_type("mpv");
		v.setBase(b);
		v.setVehicle_price(100);
		List<VehicleFull> vehicleFull = admMapper.queryVehicleFullAll("vehicle_price","DESC");
		for (VehicleFull vehicleFull2 : vehicleFull) {
			System.out.println(vehicleFull2);
		}
		
	}
	
	
	@Test
	public void testqueryOrderdetail() throws IOException{
		initSession();
		Orderdetail orderdetail = new Orderdetail();
		orderdetail.setUser(new User());
		List<Orderdetail> queryOrderDetail = admMapper.queryOrderDetail(orderdetail);
		for (Orderdetail orderdetail2 : queryOrderDetail) {
			System.out.println(orderdetail2);
		}
	}
	
	
	@Test
	public void updataBase() throws ParseException, IOException {
		initSession();
		
		Base b=new Base();
		b.setBase_id("123123");
		//b.setBase_photo("c:/eqw.jepg");
		b.setBase_type("suv");
		b.setBase_brand("别克");
		//b.setBase_model("昂科威");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		java.util.Date date = dateFormat.parse("2016.8.31");
		b.setBase_produced(new Date(date.getTime()));
		b.setBase_displacement(1.5);
		b.setBase_speed(190);
		
		admMapper.updataBase(b);
		session.commit();
	}
	
	@Test
	public void updataOrder() throws ParseException, IOException {
		initSession();
		
		Order o=new Order();
		
		o.setOrder_id(CreatSqlDateByStr.creatUtilDateByString("2020-01-06 21:28:26"));
		o.setOrder_startDate(CreatSqlDateByStr.creatDateByString("2020-1-6"));
		o.setOrder_quantity((short)7);
		admMapper.updataOrder(o);
		session.commit();
	}
	
	@Test
	public void updateVehicle() throws IOException {
		initSession();
		Vehicle v=new Vehicle();
		v.setVehicle_id("1212");
		v.setVehicle_employee_id("54321");
		v.setVehicle_price(1200);
		admMapper.updataVehicle(v);
		session.commit();
		
	}
	
	
	
	
	public void initSession() throws IOException {
		Reader reader = null;
		SqlSessionFactoryBuilder sessionFactoryBuilder = null;
		SqlSessionFactory sessionFactory = null;;
		reader = Resources.getResourceAsReader("mybatis/mybatisconfig.xml");
		sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		sessionFactory = sessionFactoryBuilder.build(reader);
		session = sessionFactory.openSession();
		admMapper = session.getMapper(AdmMapper.class);
	}
}
