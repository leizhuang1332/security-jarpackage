package com.lz.admin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TimeUtil {
	public static String getNow(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	public static String formate(Date a){
		  SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	      return  sdf.format(a);
	  }
	
	public static String longToDate(long l) {
		Date aa = new Date();
		aa.setTime(l);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String str=sdf.format(aa);
		return str;
	}
	/**
	 * yyyy-MM-dd
	 * @return
	 */
	public static  String getNowDay(){
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate date1 = currentTime.toLocalDate();
		return date1+"";
	}

	/**
	 * yyyy-MM
	 * @return
	 */
	public static  String getNowDate(){
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate date1 = currentTime.toLocalDate();
		return (date1+"").substring(0, 7);
	}
	
	/**
	 * 字符串的时间转换为Date类型
	 * @param str	目标字符串
	 * @param format	时间字符串格式
	 * @return Date
	 */
	public static Date strToDate(String str,String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		Date date = null;
		try {
			date=sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 字符串的时间转换为Date类型
	 * @param str	目标字符串
	 * @param format	时间字符串格式
	 * @return Date
	 */
	public static String dateToStr(Date date,String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		String str = null;
		try {
			str=sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 根据一天的开始时间获得结束时间
	 */
	public static String getEndDate(String startDate){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=sdf.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 Calendar calendar = new GregorianCalendar();
	     calendar.setTime(date);
	     calendar.set(Calendar.HOUR,23);
	     calendar.set(Calendar.MINUTE,59);
	     calendar.set(Calendar.SECOND,59);
	     calendar.set(Calendar.MILLISECOND,999);
	     return sdf.format(calendar.getTime());
	}
	
	/**
	 * 获得今天的时间
	 * @return
	 */
	public static String getToday(String str){
		SimpleDateFormat sdf=new SimpleDateFormat(str);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
//		calendar.add(Calendar.DATE,-1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		return sdf.format(calendar.getTime());
	}
	
	/**
	 * 获得30天前的时间
	 * @return
	 */
	public static String getThirtyDaysBefore(String str){
		SimpleDateFormat sdf=new SimpleDateFormat(str);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -30);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		return sdf.format(calendar.getTime());
	}
	
	/**
	 * Date类型转字符串
	 * @param date Date类型
	 * @param str
	 * @return
	 */
	public static String dateFormat(Date date,String str){
		SimpleDateFormat sdf=new SimpleDateFormat(str);
		return sdf.format(date);
	}
	
	/**
	 * 
	 * @param date	String类型
	 * @param str_date	String类型的时间的格式
	 * @param str
	 * @return
	 */
	public static String dateFormat(String date,String str_date,String str){
		SimpleDateFormat sdf1=new SimpleDateFormat(str_date);
		SimpleDateFormat sdf2=new SimpleDateFormat(str);
		Date date1=null;
		try {
			date1=sdf1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return sdf2.format(date1);
	}
	
	public static List<String> getWholeMonthDays(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		List<String> list = new ArrayList();
		String endDateStr=getThirtyDaysBefore("yyyy-MM-dd");
		Date endDate=strToDate(endDateStr,"yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		while(calendar.getTime().compareTo(endDate)>=0){
			list.add(sdf.format(calendar.getTime()));
			calendar.add(Calendar.DATE, -1);
		}
		return list;
	}
	
	public static List<String> findDates(String dBegin, String dEnd, String duration){  
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");  
	  SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");  
	  List<String> li=new ArrayList<>();
	  try {
	  Calendar calBegin = Calendar.getInstance();  
	  // 使用给定的 Date 设置此 Calendar 的时间  
	  calBegin.setTime(sdf.parse(dBegin));  
	  Calendar calEnd = Calendar.getInstance();  
	  // 使用给定的 Date 设置此 Calendar 的时间  
	  calEnd.setTime(sdf.parse(dEnd));  
	  // 测试此日期是否在指定日期之后  
	  if(duration.equals("daily")){
		  li.add(sdf1.format(calBegin.getTime()));
	  }else{
		  li.add(sdf2.format(calBegin.getTime()));
	  }
	  while (sdf.parse(dEnd).after(calBegin.getTime())) {   
	   // 根据日历的规则，为给定的日历字段添加或减去指定的时间量  
		  if(duration.equals("daily")){
	  		  calBegin.add(Calendar.DAY_OF_MONTH, 1);
	  		String a=sdf1.format(calBegin.getTime());
	  		li.add(a);
		  }else{
			  calBegin.add(Calendar.MONTH, 1);
			  String a=sdf2.format(calBegin.getTime());
			  li.add(a);
		  }
	  } 
	  li.remove(li.get(li.size()-1));
	  } catch (ParseException e) {
		  e.printStackTrace();
	  }  
	  return li;  
	 }  
	
	public static List<String> findDates1(String dBegin, String dEnd, String duration){  
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		  List<String> li=new ArrayList<>();
		  try {
		  Calendar calBegin = Calendar.getInstance();  
		  // 使用给定的 Date 设置此 Calendar 的时间  
		  calBegin.setTime(sdf.parse(dBegin));  
		  Calendar calEnd = Calendar.getInstance();  
		  // 使用给定的 Date 设置此 Calendar 的时间  
		  calEnd.setTime(sdf.parse(dEnd));  
		  // 测试此日期是否在指定日期之后  
		  li.add(sdf.format(calBegin.getTime()));
		  while (sdf.parse(dEnd).after(calBegin.getTime())) {   
		   // 根据日历的规则，为给定的日历字段添加或减去指定的时间量  
		  		calBegin.add(Calendar.DAY_OF_MONTH, 1);
		  		String a=sdf.format(calBegin.getTime());
		  		li.add(a);
		  } 
		  li.remove(li.get(li.size()-1));
		  } catch (ParseException e) {
			  e.printStackTrace();
		  }  
		  return li;  
		 } 
	
	 public static String getDate(int days){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		 Calendar theCa = Calendar.getInstance();
		 theCa.setTime(new Date());
		 theCa.add(theCa.DATE, days);
		 Date start = theCa.getTime();
		 String startDate = sdf.format(start);//三十天之前日期
		return startDate;
	 }
	 
	 public static String getOneAgoHour(String endtime){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		 Date a = null;
		try {
			a = sdf.parse(endtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 Calendar theCa = Calendar.getInstance();
		 theCa.setTime(a);
		 theCa.add(theCa.HOUR_OF_DAY, -2);
		 Date start = theCa.getTime();
		 String startDate = sdf.format(start);
		return startDate;
	 }
	 public static void main(String[] args) {
//		 String nowDay = getNowDate();
//		 System.out.println(nowDay);
		 String dateLastDay = getDateLastDay("2019","5",0);
		 System.out.println(dateLastDay);
	 }
	 
	 public static int getMinutesDifference(Date larger_date,Date smaller_date){
		 long between = (larger_date.getTime() - smaller_date.getTime())/1000;
		 long min = between/60;
		 return (int)min;
	 }
	 /**
	  * @Title: getDateLastDay   
	  * @author: Mr man    
	  * @Description: 获取每月的第一天或者最后一天  (有效日期)
	  * @param: @param year
	  * @param: @param month
	  * @param: @param type  0 获取最后一天  1 获取第一天
	  * @param: @return      
	  * @return: String      
	  * @throws
	  */
	 public static String getDateLastDay(String year, String month,Integer type) {
	      //year="2018" month="2" 
	      Calendar calendar = Calendar.getInstance();
	      // 设置时间,当前时间不用设置
	      calendar.set(Calendar.YEAR, Integer.parseInt(year));
	      calendar.set(Calendar.MONTH, Integer.parseInt(month));
	      // System.out.println(calendar.getTime());
	      calendar.set(Calendar.DAY_OF_MONTH, 1); 
	      if(type ==0) {
	    	  calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
	      }else if(type ==1) {
	    	  calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
	      }
	      DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	      long time = calendar.getTime().getTime();
	      long currentTimeMillis = System.currentTimeMillis();
	      if(time > currentTimeMillis) {
	    	  return format.format(new Date());
	      }
	      return format.format(calendar.getTime());
	}
	 
	 
}
