package cn.tongRenCollege.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class UUIDCreater {
	
	public static String getUUID() {
		String uuid="";
		for (int i = 0; i < 5; i++) {
            //注意replaceAll前面的是正则表达式
            uuid = UUID.randomUUID().toString().replaceAll("-","");
        }
		return uuid;
	}
	
	public static String getDateID() {
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(date);
	}

}
