package cn.tongRenCollege.service.admin;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.Orderdetail;
import cn.tongRenCollege.dao.mapper.AdmMapper;

@Service
public class OrderManagerService {
	
	@Autowired
	AdmMapper admMapper;
	
	
	/**
	 * 条件查询订单详细信息 服务方法
	 * @param orderdetail
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<Orderdetail> queryOrderdetailList(Orderdetail orderdetail){
		
		return admMapper.queryOrderDetail(orderdetail);
	}
	
	/**
	 * 获取最近七天订单的数量变化情况
	 * @return
	 */
	@Transactional(readOnly=true)
	public String getChartData() {
		
		int[] ss= new int[7];
		Date date=new Date(System.currentTimeMillis());	
		for (int i = 0; i < ss.length; i++) {
			ss[i]=getOrdercount(date.toString());
			date.setDate(date.getDate()-1);
		}
		
		
		return "["+ss[0]+","+ss[1]+","+ss[2]+","+ss[3]+","+ss[4]+","+ss[5]+","+ss[6]+"]";
	}
	
	
	/**
	 * 读取某一天的订单的数量
	 * @param date
	 * @return
	 */
	@Transactional(readOnly=true)
	private int getOrdercount(String date) {
		List<Order> listOrder = admMapper.queryOrderByOneDay(date);
		
		return listOrder.size();
	}
	
}
