package cn.tongRenCollege.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.tongRenCollege.dao.Base;
import cn.tongRenCollege.dao.VehicleFull;

/**
 * 拷贝磁盘中的图片到服务器中,并且转换对象中的图片的路径为服务器中存放的路径
 * 
 * @author Administrator
 *
 */
@Component
public class PhotoPathTranslation {

	@Autowired
	SelvetContext selvetContext;
	@Autowired
	CopyPhoto copyPhoto;
	@Autowired
	HttpSession session;
	
	/**
	 * 对Base列表的图片路径进行拼接转换和图片的导入服务器
	 * @param baselist
	 * @return
	 */
	public List<Base> baselistTranslation(List<Base> baselist){
		for (Base base : baselist) {
			base = baseTranslation(base);
		}
		return baselist;
		
	}
	
	
	/**
	 * 转换图片路径,并拷贝磁盘的图片到服务器
	 * @param base
	 * @return
	 */
	public Base baseTranslation(Base base) {
		String originName="";
		String endName="";
		//开始路径
		originName=selvetContext.diskImgePath+base.getBase_photo();
		//结尾路径
		endName=selvetContext.getDiskServletContextPath(session)+base.getBase_photo();
		try {
			//复制图片
			copyPhoto.readAndWrite(originName, endName);
			//生成网页访问图片url
			base.setBase_photo(selvetContext.imgePath+base.getBase_photo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return base;
	}
	
	
	
	
	
	/**
	 * 对VehicleFull列表的图片路径进行拼接转换和图片的导入服务器
	 * @param vehicleFulllist
	 * @return
	 */
	public List<VehicleFull> vehicleFulltranslation(List<VehicleFull> vehicleFulllist){
		for (VehicleFull vehicleFull : vehicleFulllist) {
			
			vehicleFull.setBase(baseTranslation(vehicleFull.getBase()));
			
		}
		return vehicleFulllist;
	}
	
	
	
}
