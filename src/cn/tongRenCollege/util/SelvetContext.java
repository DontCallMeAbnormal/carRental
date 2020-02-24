package cn.tongRenCollege.util;

import javax.servlet.http.HttpSession;

/**
 * 这个类存储整个web项目所需要的常量值
 * @author Administrator
 *
 */
public class SelvetContext {
	
	/**
	 * session.getServletContext().getRealPath("/") + "/static/photo/upload/";
	 * 图片服务器路径
	 */
	public String imgePath;
	
	/**
	 * 图片的磁盘路径
	 */
	public String diskImgePath;
	
	/**
	 * 获取图片在服务器中的磁盘路径
	 * @param session
	 * @return
	 */
	public String getDiskServletContextPath(HttpSession session) {
		return session.getServletContext().getRealPath("/") + imgePath;
	}
	
	public String getDiskImgePath() {
		return diskImgePath;
	}

	public void setDiskImgePath(String diskImgePath) {
		this.diskImgePath = diskImgePath;
	}

	public String getImgePath() {
		return imgePath;
	}

	public void setImgePath(String imgePath) {
		this.imgePath = imgePath;
	}
	
	
}
