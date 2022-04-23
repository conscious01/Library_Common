package com.common.lib_base.common;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 类名: DateOperator.<br/>
 * 
 * 功能: 用于日期操作的类。<br/>
 * 
 *
 **/
public class DateOperator {
	
	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;用于获取时间差以小时为单位。
	 *
	 * @param date1  开始时间。
	 * @param date2  结束时间。
	 * @return
	 **/
	public static Long dateDiffHours(Date date1, Date date2){

		if(date1 == null || date2 == null){
			return null;
		}

		long lHoursCount = (date2.getTime() - date1.getTime()) / (60 * 60 * 1000); 

		if((date2.getTime() - date1.getTime()) % (60 * 60 * 1000) > 0){
			lHoursCount = lHoursCount + 1;
		}

		return lHoursCount;
	}
	
	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;将两个时间相减，获得过了多少天。
	 * 
	 * @param startParkTime 开始停车的时间。
	 * @param endParkTime 停车结束的时间。
	 * 
	 * @return  
	 *    < 0  非法数据。
	 *    >= 0 停了几天。
	 */
	public static int dateDiffDays(Date startParkTime, Date endParkTime){
		
		/////////////////////////////////
		//
		// 获取开始停车的时间
		Date dtStartParkTime = new Date();
		dtStartParkTime.setYear(startParkTime.getYear());
		dtStartParkTime.setMonth(startParkTime.getMonth());
		dtStartParkTime.setDate(startParkTime.getDate());
		dtStartParkTime.setHours(0);
		dtStartParkTime.setMinutes(0);
		dtStartParkTime.setSeconds(0);

		////////////////////////////////
		//
		// 获取停止停车的时间。
		Date dtEndParkTime = new Date();
		dtEndParkTime.setYear(endParkTime.getYear());
		dtEndParkTime.setMonth(endParkTime.getMonth());
		dtEndParkTime.setDate(endParkTime.getDate());
		dtEndParkTime.setHours(0);
		dtEndParkTime.setMinutes(0);
		dtEndParkTime.setSeconds(0);
		
		////////////////////////////////
		//
		// 如果开始停车时间比结束时间还晚，则返回错误。
		if(dtStartParkTime.after(dtEndParkTime)){
			return -1;
		}
		
		///////////////////////////////
		//
		// 获取停车的时长。
	    Long lMunites = dateDiffMunite(dtStartParkTime, dtEndParkTime);
	    
	    if(lMunites == null){
	    	return -1;
	    }
	    
	    //////////////////////////////
	    //
	    // 获取停车的天数。
	    long iDays = lMunites / 60 / 24;
	    
	    
	    return (int) iDays;
	}


	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;日期相减，得到分钟。
	 *
	 * @param date1  开始时间。
	 * @param date2  结束时间。
	 * 
	 * @return 相隔了多少分。
	 **/
	public static Long dateDiffMunite(Date date1, Date date2){

		if(date1 == null || date2 == null){
			return null;
		}

		

		long lDayCount = (date2.getTime() - date1.getTime()) / (60 * 1000); 
		
		if(((date2.getTime() - date1.getTime()) / 1000) % 60 != 0){
			lDayCount = lDayCount + 1;
		}

		return lDayCount;
	}
	
	/**
	 * 用于获取两个日期的时间差（秒为单位）
	 * 
	 * @param date1
	 * @param date2
	 * 
	 * @return
	 * 
	 */
	public static Long dateDiffBySeconds(Date date1, Date date2){
		
		if(date1 == null || date2 == null){
			
			return null;
		}
		
		long lSeconds = (date2.getTime() - date1.getTime()) /  1000; 
		
		return lSeconds;
	}

	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;字符串转换成日期<br/>
	 * 
	 * @param str 如 2015-07-04 08:05:12<br/>
	 * 
	 * @return 
	 *     null 非法日期。<br/>
	 *     非null 正常日期。
	 **/
	public static Date strToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;

		try {
			date = format.parse(str);
		} catch (ParseException e) {
			return null;
		}

		return date;
	}
		
	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;日期转换成字符串。<br/>
	 * @param date
	 * @return str
	 **/
	public static String DateToStr(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(date);

		return str;
	}

	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;用于复制
	 *
	 * @param destDate
	 * @param srcDate
	 **/
	public static void dateCopy(Date destDate, Date srcDate){

		if(destDate == null || srcDate == null){
			return;
		}

		destDate.setYear(srcDate.getYear());
		destDate.setMonth(srcDate.getMonth());
		destDate.setDate(srcDate.getDate());
		destDate.setHours(srcDate.getHours());
		destDate.setMinutes(srcDate.getMinutes());
		destDate.setSeconds(srcDate.getSeconds());
	}
	
	
	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;在日期上加上iMunites分钟。
	 *
	 * @param date
	 *
	 * @return
	 **/
	public static Date dateAddMunite(Date date, long iMunites){
		
		if(date == null){
			return null;
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, (int)iMunites);
	
		
		return calendar.getTime();
	}
	
	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;用于将字符串的 08:12:59 或者 08:12 这样的字符串转为Time类型。<br/>
	 *
	 * @param strTime 需要转换成Time的字符串。
	 * 
	 * @return 
	 *      null 转换失败。<br/>
	 *      非null 成功的返回结果。
	 * 
	 **/
	public static Time strToTime(String strTime){
		
		if(strTime == null || strTime.trim().length() == 0){
		    return null;
		}
		
		strTime = strTime.trim();
		
		String[] strParts = strTime.split(":");
		
		if(strParts.length <= 1){
		    return null;
		}
		
		if(strParts.length >= 4){
		    return null;
		}
		 
		int iHour = 0;
		
		int iMunite = 0;
		
		int iSecond = 0;
		
		try{
			iHour = Integer.parseInt(strParts[0]);
			
			if(iHour < 0 || iHour >= 24){
				return null;
			}
			
		}
		catch (NumberFormatException e) {
			return null;
		}
		 
		try{
			iMunite = Integer.parseInt(strParts[1]);
			
			if(iMunite < 0 || iMunite >= 60){
				return null;
			}
			
		}
		catch (NumberFormatException e) {
			return null;
		}
		
		if(strParts.length == 2){
			iSecond = 0;
		}
		else{
			iSecond = Integer.parseInt(strParts[2]);
		}
		
		if(iSecond < 0 || iSecond >= 60){
			return null;
		}
		
		Time retTime = new Time(iHour, iMunite, iSecond);
		
		return retTime;
	}
	
	
	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;格式化分钟数成为小时等字符串。
	 * 
	 * @param lMinutes 分钟数。
	 * 
	 * 
	 * @return 小时和分钟数
	 */
	public static String formatTimeByMinutes(long lMinutes){
		
		////////////////////////
		//
		// 如果小于60分钟，则按分钟返回。
		if(lMinutes < 60){
			return lMinutes + "分";
		}
		
	    ////////////////////////
		//
		// 如果大于60分钟，先计算小时再加分钟。
		long lHours = lMinutes / 60;
		long lRemainMinutes = lMinutes % 60;
		
		if(lRemainMinutes == 0){
			return lHours + "小时";
		}
		
		return lHours + "小时" + lRemainMinutes + "分";
	}
	
	
	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;获取今天的最早时间。
	 * 
	 * @return 
	 *    null 获取失败。<br/>
	 *    非null 今天最早的时间。<br/>
	 */
	public static Date getTodayMorningDate(){
		
		Date dtNow = new Date();
		
		dtNow.setHours(0);
		dtNow.setMinutes(0);
		dtNow.setSeconds(0);
		
		return dtNow;
	}
	
	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;用于获取今天的最晚的时间。
	 *  
	 * @return
	 *    null 获取失败。<br/>
	 *    非null 获取成功。
	 */
	public static Date getTodayLastedDate(){
		
		Date dtNow = new Date();
		
		dtNow.setHours(23);
		dtNow.setMinutes(59);
		dtNow.setSeconds(59);
		
		return dtNow;
	}
    
	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;获取date这天的最早的时间。
	 * 
	 * @param date 日期。 
	 * @return
	 */
	public static String getFirstTimeByDate(Date date){
		
		String strDate = "";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		strDate = format.format(date);
		
		strDate = strDate + " 00:00:00";
		
		return strDate;
	}
	
	/**
	 * 功能:<br/>
	 * &nbsp;&nbsp;&nbsp;用于获取某天的最晚的时间。
	 * 
	 * @param date
	 * @return
	 */
	public static String getLastTimeByDate(Date date){
		
		String strDate = "";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		strDate = format.format(date);
		
		strDate = strDate + " 23:59:59";
		
		return strDate;
	}

}
