package cn.tongRenCollege.test.dao;

import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.VehicleFull;
import cn.tongRenCollege.dao.mapper.UserMapper;
import cn.tongRenCollege.util.CreatSqlDateByStr;

public class TestUserMapper {
	UserMapper userMapper = null;
	SqlSession session =null;
	
	
	@Test
	public void updateOrder() throws IOException, ParseException {
		initSession();
		Order o=new Order();
		o.setOrder_id(CreatSqlDateByStr.creatUtilDateByString("2020-01-06 21:28:26"));
		o.setOrder_user_id("32141");
		o.setOrder_price(1000);
		o.setOrder_quantity((short)5);
		userMapper.updataOrder(o);
		session.commit();
	}
	
	
	@Test
	public void getOrder() throws IOException, ParseException {
		initSession();
		Order o=new Order();
		o.setOrder_user_id("32141");
		o.setOrder_price(344);
		o.setOrder_state("预订单");
		List<Order> queryOrderHistory = userMapper.queryOrderByorder(o);
		for (Order order : queryOrderHistory) {
			System.out.println(order);
		}
		
	}
	
	
	@Test
	public void getVehicleFull() throws IOException, ParseException {
		initSession();
		List<VehicleFull> vehicleFull = userMapper.queryVehicleFullAll("vehicle_price","DESC");
		for (VehicleFull vehicleFull2 : vehicleFull) {
			System.out.println(vehicleFull2);
		}
		
	}
	
	public void initSession() throws IOException {
		Reader reader = null;
		SqlSessionFactoryBuilder sessionFactoryBuilder = null;;
		SqlSessionFactory sessionFactory = null;;
		reader = Resources.getResourceAsReader("mybatis/mybatisconfig.xml");
		sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		sessionFactory = sessionFactoryBuilder.build(reader);
		session = sessionFactory.openSession();
		userMapper = session.getMapper(UserMapper.class);
	}
	
}
