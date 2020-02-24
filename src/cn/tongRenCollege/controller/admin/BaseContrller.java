package cn.tongRenCollege.controller.admin;

import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import cn.tongRenCollege.dao.Base;
import cn.tongRenCollege.service.admin.BaseManagerService;

@Controller
public class BaseContrller {

	@Autowired
	BaseManagerService baseMS;
	
	@Autowired
	HttpSession session;
	
	
	/**
	 * 查询所有车信息
	 * @return
	 */
	@RequestMapping("/queryBaseMessg")
	@ResponseBody
	public List<Base> queryBaseMessg(){
		return baseMS.queryBaseTerm(null);
	}
	
	
	/**
	 * 
	 * 条件查询车辆信息
	 * @param base
	 * @return
	 */
	@RequestMapping("/queryBaseTerm")
	@ResponseBody
	public List<Base> queryBaseTerm(Base base){
		
		return baseMS.queryBaseTerm(base);
	}
	
	
	
	@RequestMapping(value="/addBase",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String addBase(MultipartFile fille,Base base) throws ParseException {
        try {
        	//向数据库写入数据
			baseMS.addBase(fille,base, session);
			//将文件保存指定目录
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
        
		return "success";
	}
	
	
	@RequestMapping("/updataBase")
	@ResponseBody
	public String updataBase(MultipartFile file,Base base) {
		try {
			baseMS.updataBase(file, base);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		return "success";
	}
	
	
	
	@RequestMapping(value="/deleteBase" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteBase(String id) {
		
		try {
			baseMS.deleteBase(id);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
		
		return "success";
	}
	
	
	
}
