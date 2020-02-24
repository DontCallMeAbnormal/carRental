package cn.tongRenCollege.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.tongRenCollege.dao.Base;
/**
 * 车辆基础信息管理
 * @author Administrator
 *
 */
public interface BaseManager {

	/**
	 * 查询车辆信息库的基础信息
	 * @param base
	 * @return Base集合
	 */
	public List<Base> queryBaseTerm(Base base);
	
	
	/**
	 * 为车辆信息库添加车辆的基础信息
	 * @param fille MultipartFile的图片文件
	 * @param base	Base对象,封装车辆基础信息
	 * @param session HttpSession从里面获取文件的磁盘保存路径,及在服务器中保存的路径
	 * @throws Exception
	 */
	public void addBase(MultipartFile fille,Base base,HttpSession session) throws Exception;
	
	
	
	/**
	 * 删除基础信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteBase(String id) throws Exception;
	
	
	
}
