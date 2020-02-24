package cn.tongRenCollege.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tongRenCollege.dao.Adm;
import cn.tongRenCollege.service.admin.AdminLoginSerivce;

@Controller
public class AdminLoginContrller {

	
	@Autowired
	AdminLoginSerivce admlogin;
	
	@Autowired
	HttpSession session;
	
	
	/**
	 * 管理员登录
	 * @param adm
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginAdmin")
	@ResponseBody
	public String loginAdmin(Adm adm) {
		Adm loginAdmin = admlogin.loginAdmin(adm);
		if(loginAdmin==null) {
			return "defeat";
		}
		session.setAttribute("adm", loginAdmin);
		return "success";
	}
	
	
	/**
	 * 管理员登出
	 * @return
	 */
	
	 @RequestMapping("/logoutAdmin")
	 public String logoutAdmin() {
		 session.removeAttribute("adm");
		 return "redirect:/backgroundLogin.html"; 
	 }
	 
	 
	/**
	 * 管理员信息
	 * 
	 */
	 @RequestMapping("/getAdminInfo")
	 @ResponseBody
	 public Adm getAdminInfo() {
		Adm admin = (Adm)session.getAttribute("adm");
		if(admin==null) {
			admin=new Adm();
			admin.setAdm_name("未登录");
		}
		admin.setAdm_pwd(" ");
		
		return admin; 
	 }
	 
	
}
