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
	
	
	
	
}
