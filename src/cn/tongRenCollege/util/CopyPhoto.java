package cn.tongRenCollege.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 从磁盘读取图片到服务器
 * @author Administrator
 *
 */
public class CopyPhoto {
	
	/**
	 * 读取磁盘图片,到服务器中
	 * @param originpath
	 * @param endpath
	 * @throws IOException 
	 */
	public void  readAndWrite(String originName,String endName) throws IOException {
		File originfile=new File(originName);
		File endfile=new File(endName);
		//源文件不存在则跳过
		if(!originfile.exists()) {
			return;
		}
		//目标文件存在则不覆盖
		if(endfile.exists()) {
			return;
		}
		
		
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(originfile));  //原先图片所在路径
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(endfile));  //你要保存在哪个目录下面
		  int i;  
		  while((i=in.read())!=-1){  
		   out.write(i);  
		  }  
		  out.flush();  

		  out.close();  
		  in.close();  
		  
	}  
	
	
}
