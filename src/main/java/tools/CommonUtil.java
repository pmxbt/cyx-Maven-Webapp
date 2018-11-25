package tools;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommonUtil {

	
	private static String getMonthByDateAndPattern(){
		return getMonthByDateAndPattern(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	private static  String getMonthByDateAndPattern(Date d, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(d);
	}
	
	
	/**
	 * 获取当天日期
	 * @return
	 */
	public static String getCurrentDate() {
		return getMonthByDateAndPattern(new Date(), "yyyy-MM-dd");
	}
	
	
	/**
	 * 获取当前详细时间：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurrentDateDetail() {
		return getMonthByDateAndPattern(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	
	
	/**
	 * 根据字符串和给定日期格式返回Date型
	 * @param dStr
	 * @param pattern
	 * @return
	 */
	public static Date getDateByStringAndPatter(String dStr, String pattern) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			d = sdf.parse(dStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 获取两个给定日期之间的天数集合
	 * @param startDate:开始日期,endDate:结束日期
	 */
	public static List<Date> dateSplit(String s,String e){
		Date startDate = getDateByStringAndPatter(s, "yyyy-MM-dd");
		Date endDate = getDateByStringAndPatter(e, "yyyy-MM-dd");
		Long longer = (endDate.getTime()-startDate.getTime())/(24*60*60*1000);
		List<Date> datelist = new ArrayList<Date>();
		datelist.add(startDate);
		for(int i=1;i<=longer;i++){
			datelist.add(new Date(datelist.get(i-1).getTime()+(24*60*60*1000)));
		}
		return datelist;
	}
	
	/**
	 ** 获取两个给定日期之间的天数,返回数字
	 * @param startDate:开始日期,endDate:结束日期
	 */
	public static int numberOfDays(String s,String e){
		Date startDate = getDateByStringAndPatter(s, "yyyy-MM-dd");
		Date endDate = getDateByStringAndPatter(e, "yyyy-MM-dd");
		//锟斤拷锟斤拷锟斤拷锟�
		Long longer = (endDate.getTime()-startDate.getTime())/(24*60*60*1000);
		return Integer.parseInt(String.valueOf(longer));
	}

	/**
	 * 根据给定日期及加减天数，获取新的日期
	 * @param d 给定日期
	 * @param amount 加减天数
	 * @return
	 */
	public static Date getReDate(Date d, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, amount);
		return c.getTime();
	}
	
	/**
	 * 根据日期获取指定格式字符串
	 * @param date 日期
	 * @param pattern 日期字符串格式 如："yyyy-MM-dd" 如果不传，默认为"yyyy-MM-dd"
     * @return
	 */
	public static String getDateStr(Date date, String...pattern) {
		String p = null;
		if (CommonUtil.notEmpty(pattern)) {
			p = pattern[0];
		} else {
			p = "yyyy-MM-dd";
		}
		return getMonthByDateAndPattern(date, p);
	}
	
	/**
	 * 判断是否不为空，适用于字符串、集合、数组；为空返回false，不为空返回true;
	 * @param obj
	 * @return
	 */
	public static boolean notEmpty(Object obj) {
		return !isEmpty(obj);
	}
	
	
	
	/**
	 * 判断是否为空，适用于字符串、集合、数组；为空返回true，不为空返回false;
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean isEmpty(Object obj) {
		if (obj == null) return true;
		if (obj instanceof CharSequence) {
			return ((CharSequence)obj.toString().trim()).length() == 0;
		} else if (obj instanceof String) {
			return obj != null && !"".equals(((String) obj).trim()) ? false : true;
		} else if (obj instanceof Collection) {
			return ((Collection)obj).isEmpty();
		} else if (obj instanceof Map) {
			return ((Map)obj).isEmpty();
		} else if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		return false;
	}
	
	/**
	 * 根据日期获取当月天数
	 * @param date
	 * @return
	 */
	public static int getDaysOfMonth(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	
	/**
	 * 获取当天日期在本年为第几天
	 * @param date
	 * @return
	 */
	public static int getDayOfYear(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int i = c.get(Calendar.DAY_OF_YEAR);
		return i;
	}
	
	/**
	 * 根据日期获取当年天数
	 * @param date
	 * @return
	 */
	public static int getDaysOfYear(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int i = c.getActualMaximum(Calendar.DAY_OF_YEAR);
		return i;
	}
	/**
	 * 获取当天日期在本月为第几天
	 * @param date
	 * @return
	 */
	public static int getDayOfMonthNow(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int i = c.get(Calendar.DAY_OF_MONTH);
		return i;
	}
	
	
	public static int getWeekByDateStr(String startDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(CommonUtil.getDateByStringAndPatter(startDate, "yyyy-MM-dd"));
		int i = c.get(Calendar.DAY_OF_WEEK);
		return i;
	}
	
}
