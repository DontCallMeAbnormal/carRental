package cn.tongRenCollege.test.other;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TestPojectCodeCount {
	private static int i;//代码总行数
	private static int j;//文件个数
	
	private static int oldI;//上次的代码总数
	private static int oldJ;//上次的文件总数
	
	public static void main(String[] args){
		//需要统计行数的文件夹路径
		File file = new File("D:\\graduation project\\carRentalDynamicWeb");
		//日志路径
		File outfile = new File("D:\\graduation project\\carRentalDynamicWeb\\src\\cn\\tongRenCollege\\test\\other\\log.txt");
		//缓存路径
		File chace=new File("D:\\graduation project\\carRentalDynamicWeb\\src\\cn\\tongRenCollege\\test\\other\\log.properties");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(new Date(System.currentTimeMillis()));
		
		
		BufferedWriter out=null;
		try {
				//计算本次代码量
				traverseFiles(file);
				//读取上次代码量
				readProper(chace);
				
				//计算差量
				String conent1 ="本次写文件个数："+(j-oldJ);
				String conent2 ="本次写代码行数："+(i-oldI);
				
				String conent3 ="总文件数："+j+"  总行数"+i;
				String conent4 =time;
				String conent5 ="----------------";
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile, true)));
				out.newLine();
				out.write(conent1);
				out.newLine();
				out.write(conent2);
				out.newLine();
				out.write(conent3);
				out.newLine();
				out.write(conent4);
				out.newLine();
				out.write(conent5);
				
				//记录本次代码量
				writeProper(chace);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {                                                                 
            try {                                                                    
                out.close();                                                        
            } catch (IOException e) {                                               
                e.printStackTrace();                                                
            }                                                                       
        }   
		
		
		System.out.println("所写文件个数："+(j-oldJ));
		System.out.println("所写代码总行数："+(i-oldI));
		
		
	}

	private  static void traverseFiles(File file) throws IOException {
		// TODO Auto-generated method stub
		if(!file.exists()){//文件不存在
			return;
		}
		if(!file.isDirectory()){//判断是否为文件
			String filename = file.getName();
			if(filename.endsWith(".java") || filename.endsWith(".xml") || filename.endsWith(".html") || filename.endsWith(".js") || filename.endsWith(".css")){//判断是否是.java文件
				j++;
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				String string =null;
				while ((string = bufferedReader.readLine()) != null) {
					i++;//读取行数
				}
			}else
			   return;
		}
		
		File[] files =file.listFiles();//读取文件夹的子文件或子文件夹
		if (files == null || files.length == 0) {
			return;
		}
		
		for(File file2 : files){//如果是文件夹递归调用方法遍历文件
			traverseFiles(file2);
		}
		
	}
	
	private static void readProper(File file) {
		Properties pro=new Properties();
		try {
			InputStream in = new BufferedInputStream (new FileInputStream(file));
			pro.load(in);
			oldI=Integer.parseInt(pro.getProperty("oldI"));
			oldJ=Integer.parseInt(pro.getProperty("oldJ"));
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void writeProper(File file) {
		Properties pro=new Properties();
		try {
			FileOutputStream in = new FileOutputStream (file);
			pro.setProperty("oldI", i+"");
			pro.setProperty("oldJ", j+"");
			pro.store(in, "");
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
