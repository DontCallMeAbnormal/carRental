package cn.tongRenCollege.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tongRenCollege.dao.Adm;
import cn.tongRenCollege.dao.mapper.AdmMapper;

@Service
public class AdminLoginSerivce {
	
	@Autowired
	AdmMapper admMapper;
	
	/**
	 * 管理员登录
	 * @param adm
	 * @return
	 */
	@Transactional(readOnly=true)
	public Adm loginAdmin(Adm adm) {
		Adm admtest = admMapper.getAdm(adm);
		
		return admtest;
	}

	
	
	
	
}
