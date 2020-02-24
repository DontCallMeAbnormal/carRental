package cn.tongRenCollege.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreatSqlDateByStr {
	
	/**
	 * 将字符串转换为java.sql.Date类型.默认使用格式"yyyy-MM-dd"
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date creatDateByString(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date udate = dateFormat.parse(date);
		return new Date(udate.getTime());
	}
	
	/**
	 * 将字符串转换为java.sql.Date类型,参数二指定使用的格式
	 * @param date
	 * @param datePattern
	 * @return
	 * @throws ParseException
	 */
	public static Date creatDateByString(String date,String datePattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		java.util.Date udate = dateFormat.parse(date);
		return new Date(udate.getTime());
	}
	
	
	
	
	
	
	
	/**
	 * 将字符串转换为java.util.Date类型.默认使用格式"yyyy-MM-dd hh:mm:ss"
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static java.util.Date creatUtilDateByString(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.parse(date);
	}
	
	
	
	
	
	/**
	 * 将字符串转换为java.util.Date类型,参数二指定使用的格式
	 * @param date
	 * @param datePattern
	 * @return
	 * @throws ParseException
	 */
	public static java.util.Date creatUtilDateByString(String date,String datePattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		return dateFormat.parse(date);
	}
	
	
}
