package cn.tongRenCollege.service.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import cn.tongRenCollege.dao.Adm;
import cn.tongRenCollege.dao.Base;
import cn.tongRenCollege.dao.mapper.AdmMapper;
import cn.tongRenCollege.model.BaseManager;
import cn.tongRenCollege.util.CopyPhoto;
import cn.tongRenCollege.util.PhotoPathTranslation;
import cn.tongRenCollege.util.SelvetContext;
import cn.tongRenCollege.util.UUIDCreater;

@Service
public class BaseManagerService implements BaseManager{

	@Autowired
	AdmMapper admMapper;
	@Autowired
	SelvetContext selvetContext;
	@Autowired
	CopyPhoto copyPhoto;
	@Autowired
	HttpSession session;
	@Autowired
	PhotoPathTranslation pption;
	
	/**
	 * 车辆信息查询,为空则查全部 ,
	 * @param base
	 * @return
	*/
	@Transactional
	public List<Base> queryBaseTerm(Base base){
		List<Base> queryBase = admMapper.queryBase(base);
		return pption.baselistTranslation(queryBase);
	}
	
	/**
	 * 添加基础信息,并将图片写入磁盘
	 * @param fille
	 * @param base
	 * @param session
	 * @throws Exception
	 */
	@Transactional
	public void addBase(MultipartFile fille,Base base,HttpSession session) throws Exception {
		if(session.getAttribute("adm") == null) 
		{
			throw new Exception("管理员未登录");
		}
		
		if (fille == null || base.getBase_brand()==null || base.getBase_type()==null ) {
            throw new Exception("至少填写品牌和车的类型,以及添加图片");
        }
        if (fille.getSize() > 1024 * 1024 * 5) {
        	
        	throw new Exception("大小不能超过5MB");
        }
		
      //获取文件后缀
        String suffix = 
        		fille.getOriginalFilename().substring(fille.getOriginalFilename().lastIndexOf(".") + 1,
        				fille.getOriginalFilename().length());
        
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
        	throw new Exception("请选择jpg,jpeg,gif,png格式的图片！");
        }
        
        
        //获取项目根目录加上图片目录,保存到磁盘
        String savePath = selvetContext.diskImgePath;
    
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        
        //生成ID名
        String baseId=UUIDCreater.getDateID();
        //生成文件名
        String fileName=baseId+"." + suffix;
        
        base.setBase_id(baseId);
        base.setBase_photo(fileName);
		
		//保存到指定目录
    	fille.transferTo(new File(savePath+fileName));
    	
    	System.out.println("文件保存到:  "+savePath);
    	admMapper.addBase(base);
		
	}
	
	
	
	
	
	
	/**
	 * 删除基础基础信息
	 * @param id
	 * @throws Exception
	 */
	@Transactional(rollbackFor= {Exception.class,MySQLIntegrityConstraintViolationException.class})
	public void deleteBase(String id) throws Exception {
		if(session.getAttribute("adm") == null) 
		{
			throw new Exception("管理员未登录");
		}
		
		//从数据库删除数据
		admMapper.removeBaseById(id);

		Base base = admMapper.getBaseById(id);//查询该对象
		String phtotPath=selvetContext.diskImgePath+base.getBase_photo();//获取图片路径
		File file=new File(phtotPath);
		//如果图片存在则将图片也删除
		if(file.exists()) {
			file.delete();
		}
	}
	
	
	
	
	/**
	 * 修改基础信息,更换图片
	 * @param file
	 * @param base
	 * @throws Exception 
	 */
	@Transactional
	public void updataBase(MultipartFile file,Base base) throws Exception {
		if(session.getAttribute("adm")==null) {
			throw new Exception("管理员未登录");
		}
		
		
        if(file!=null) {
        	if (file.getSize() > 1024 * 1024 * 5) {
        		
        		throw new Exception("大小不能超过5MB");
        	}
        	//获取文件后缀
            String suffix = 
            		file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1,
            				file.getOriginalFilename().length());
            
            if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            	throw new Exception("请选择jpg,jpeg,gif,png格式的图片！");
            }
            
            
            //获取项目根目录加上图片目录,保存到磁盘
            String savePath = selvetContext.diskImgePath;
        
            File savePathFile = new File(savePath);
            if (!savePathFile.exists()) {
                //若不存在该目录，则创建目录
                savePathFile.mkdir();
            }
            
            //获取ID名
            String baseId=base.getBase_id();
            //生成文件名
            String fileName=baseId+"." + suffix;
            
            
            base.setBase_photo(fileName);
    		
    		//保存到指定目录
        	file.transferTo(new File(savePath+fileName));
        	
        }
        
      
    	admMapper.updataBase(base);
	} 
	
	
	
	
	
	
}
