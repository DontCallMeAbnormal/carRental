package cn.tongRenCollege.model;

import java.util.List;

import cn.tongRenCollege.dao.Order;
import cn.tongRenCollege.dao.Orderdetail;

/**
 * 订单模块
 * @author Administrator
 *
 */
public interface OrderModel {

	/**
	 * 查询订单
	 * @return Orderdetail
	 */
	public List<Orderdetail> queryOrderdetailList(Orderdetail orderdetail);
	
	
	/**
	 * 修改订单
	 * @param order
	 * @return
	 * @throws Exception 
	 */
	public void updata(Order order) throws Exception;
	
	
	/**
	 * 新增订单
	 * @param order
	 * @throws Exception 
	 */
	public void createrOrder(Order order) throws Exception;

	/**
	 * 新增订单
	 * startDate必须是今天或今天之后
	 * stopDate根据dayNum计算
	 * @param order 
	 * @param dayNum stopDate根据startDate来加上dayNum计算
	 * @throws Exception
	 */
	void createrOrder(Order order, int dayNum) throws Exception;
	
	
}
