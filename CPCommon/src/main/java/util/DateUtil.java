package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**     
* @author 李安迪
* @date 2017年12月12日
* @description 处理日期的类
*/
public class DateUtil {
	

	private static final String dateFormat = "yyyyMMdd";
	private static final DateFormat df = new SimpleDateFormat(dateFormat);
	/**
	 * 
	 * @param date
	 * @return 该日期所表示的年月日
	 */
	
	@SuppressWarnings("deprecation")
	public static int getYear(Date date){
		return date.getYear()+1900;
	}
	
	@SuppressWarnings("deprecation")
	public static int getMonth(Date date){
		return date.getMonth()+1;
	}
	
	@SuppressWarnings("deprecation")
	public static int getDay(Date date){
		return date.getDate();
		
	}
	@SuppressWarnings("deprecation")
	public static Date getDate(int year,int month,int day){
		
		return new Date(year-1900,month-1,day);
	}	
	
	/**
	 * 
	 * @param listID XX-yyyyMMdd-XX格式的字符串
	 * @return 对应的Date对象
	 */
	public static Date getDateFromListID(String listID){
		if(listID == null)
			return null;
		String date = listID.substring(listID.indexOf('-')+1, listID.lastIndexOf('-'));
		return getDate(date);
	}
	
	/**
	 * 
	 * @param listID XX-yyyyMMdd-XX格式的字符串
	 * @return yyyyMMdd格式的字符串
	 */
	public static String getDateFromListIDAsString(String listID){
		if(listID == null)
			return null;
		String date = listID.substring(listID.indexOf('-')+1, listID.lastIndexOf('-'));
		return date;
	}
	/**
	 * 
	 * @param date yyyyMMdd格式的字符串
	 * @return 对应的Date类型的对象
	 */
	public static Date getDate(String date){
		
		try {
			return df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return yyyyMMdd格式的日期字符串
	 */
	public static String getCurrentDate(){
		Date date = new Date();
		return df.format(date);
	}
	
	/**
	 * 
	 * @param date Date类型的日期
	 * @return	yyyyMMdd格式的日期
	 */
	public static String getStringDate(Date date){
		return df.format(date);
	}
	
	/**
	 * 
	 * @param startTime
	 * @param finishTime
	 * @return 是否合法
	 */
	public static boolean validStartAndFinish(Date startTime, Date finishTime){
		return validDate(startTime)&&validDate(finishTime)&&validDateOrder(startTime,finishTime);
	}
	/**
	 * 
	 * @param date
	 * @return 日期是否合法
	 */
	public static boolean validDate(Date date){
		System.out.println(date);
    	
		int year = getYear(date);
		int month = getMonth(date);
		int day = getDay(date);
		
		System.out.println(day+"");
		
		if(month<1 || month >12){
			System.out.println("not valid single time for month error");
			return false;
		}
		
        int[] monthLengths = new int[]{0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  
        if(isLeapYear(year)){  
            monthLengths[2] = 29;  
        }else{  
            monthLengths[2] = 28;  
        }  
        int monthLength = monthLengths[month];  
        if(day<1 || day>monthLength){  

        	System.out.println("not valid single time");
            return false;     
        }  
        return true;  
    }  
      

    /** 是否是闰年 */  
    private static boolean isLeapYear(int year){  
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ;  
    }
    
    /**
     * 
     * @param startTime 开始时间
     * @param finishTime 结束时间
     * @return 开始时间是否早于结束时间
     */
    private static boolean validDateOrder(Date startTime,Date finishTime){
    	if(startTime.before(finishTime))
    		return true;
    	else{
    		System.out.println("not valid order");
    		return false;
    		
    	}
    }

}
