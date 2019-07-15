package com.shopping.util;

import com.aliyun.openservices.shade.io.netty.util.internal.StringUtil;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

/**
 * 日期操作类
 * 
 * @author 荣刚 2016-11-4
 *
 */
public class DateUtil {
	private DateUtil() {
	}

	public static final String ISO_DATETIME_FORMAT = "dd-MMM-yyyy HH:mm:ss";
	public static final String ISO_DATETIME_WITH_MILLISECOND_FORMAT = "dd-MMM-yyyy HH:mm:ss.SSS";
	public static final String ISO_DATE_FORMAT = "dd-MMM-yyyy";
	public static final String ISO_SHORT_DATE_FORMAT = "dd-MMM-yy";
	public static final String ISO_TIME_FORMAT = "HH:mm:ss";
	public static final String ISO_TIME_WITH_MILLISECOND_FORMAT = "HH:mm:ss.SSS";
	public static final String UNIX_LONG_DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";
	public static final String US_DATE_FORMAT = "MM/dd/yyyy";
	public static final String US_SHORT_DATE_FORMAT = "MM/dd/yy";

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


	public static Long  convertDateToTimeMills(String date)
	{
		if(StringUtils.isEmpty(date))
		{
			return 0L;
		}
		try {
			SimpleDateFormat sdf =new SimpleDateFormat(DATETIME_FORMAT);
			Date formatDate = sdf.parse(date);
			return formatDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0L;
	}


	public static String dateFormat(Date date)
	{
		SimpleDateFormat sdf =new SimpleDateFormat(DATETIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 将日期格式化为特定的字符串(Date to String)
	 * 
	 * @param date
	 *            java.util.Date
	 * @param format
	 *            可以为null,默认格式为"yyyy-MM-dd HH:mm:ss"
	 * @return 返回"yyyy-MM-dd"格式的字符串,如果为空或null则的返回空
	 * @throws Exception
	 */
	public static String format(Date date, String format) throws Exception {
		if (date == null) {
			return "";
		}
		try {
			if (format == null) {
				format = DATETIME_FORMAT;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception ex) {
			Exception ue = new Exception("日期格式化产生异常", ex);
			throw ue;
		} catch (Throwable t) {
			throw new Exception("日期格式化产生异常", t);
		}
	}

	/**
	 * 将日期格式化为特定的字符串(Date to String)
	 * 
	 * @param date
	 *            java.util.Date
	 * @return 返回"yyyy-MM-dd"格式的字符串
	 * @throws Exception
	 */
	public static String format(Date date) throws Exception {

		return format(date, null);
	}

	/**
	 * 将日期字符串解析为日期类型(String to Date)
	 * 
	 * @param dateString
	 *            不可心为null或空
	 * @param format
	 *            可以为null,默认格式化"yyyy-MM-dd"
	 * @return
	 * @throws Exception
	 */
	public static Date parse(String dateString, String format) throws Exception {

		try {
			if (format == null) {
				format = DATETIME_FORMAT;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(dateString);
		} catch (Exception ex) {
			Exception ue = new Exception("格式化日期产生异常", ex);
			throw ue;
		} catch (Throwable t) {
			throw new Exception("格式化日期产生异常", t);
		}
	}

	/**
	 * 将日期格式化为特定的字符串(Date to String)
	 * 
	 * @param dateString
	 * @return
	 * @throws Exception
	 */
	public static Date parse(String dateString) throws Exception {

		return parse(dateString, null);
	}

	/**
	 * 比较两个日期间隔，返回天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long getPeriodDate(Date d1, Date d2) {
		return (d1.getTime() - d2.getTime()) / 1000 / 60 / 60 / 24;
	}

	/***
	 * 得到两个时间相隔的时间差
	 * 
	 * @param start
	 *            开始时间字符串 yyyy-MM-dd HH:mm:ss
	 * @param end
	 *            结束时间字符串 yyyy-MM-dd HH:mm:ss
	 * @return XX天XX小时XX分XX秒
	 */
	public static String getTimelag(String start, String end) throws Exception {
		Date now;
		Date date;
		try {
			now = parse(start);
			date = parse(end);
			return getTimelag(now, date);
		} catch (Exception ex) {
			Exception ue = new Exception("获取间隔日期时产生异常", ex);
			throw ue;
		}
	}

	/***
	 * 得到两个时间相隔的时间差
	 * 
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return XX天XX小时XX分XX秒
	 */
	public static String getTimelag(Date start, Date end) throws Exception {
		try {
			long l = end.getTime() - start.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			return "" + day + "天" + hour + "小时" + min + "分" + s + "秒";

		} catch (Exception ex) {
			Exception ue = new Exception("获取间隔日期时产生异常", ex);
			throw ue;
		}
	}

	/**
	 * 得到当天时间的区域 如：2011-11-04 00：00：00 ~ 2011-11-04 23：59：59
	 * 
	 * @return
	 */
	public static String[] getCurrentTimeRange() {
		Calendar start = Calendar.getInstance();

		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);

		Calendar end = Calendar.getInstance();

		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		end.set(Calendar.SECOND, 59);

		String[] timeRange = new String[2];
		try {
			timeRange[0] = DateUtil.format(start.getTime());
			timeRange[1] = DateUtil.format(end.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeRange;
	}

	/**
	 * 得到两个日期的时间区域
	 * 
	 * @param day
	 * @return
	 */
	public static String[] getTimeRange(String day) {
		if (StringUtil.isNullOrEmpty(day)) {
			day = getSomeDay(0);
		}

		Calendar start = Calendar.getInstance();
		try {
			start.setTime(DateUtil.parse(day, DATE_FORMAT));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);

		Calendar end = Calendar.getInstance();
		try {
			end.setTime(DateUtil.parse(day, DATE_FORMAT));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		end.set(Calendar.SECOND, 59);

		String[] timeRange = new String[2];
		try {
			timeRange[0] = DateUtil.format(start.getTime());
			timeRange[1] = DateUtil.format(end.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeRange;
	}

	/**
	 * 得到某天
	 * 
	 * @param interval
	 * @return
	 */
	public static String getSomeDay(int interval) {
		String day = null;
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH)
				+ interval);

		try {
			day = DateUtil.format(now.getTime(), DateUtil.DATE_FORMAT);
		} catch (Exception e) {
		}
		return day;
	}

	/**
	 * 得到某天
	 * 
	 * @return
	 */
	public static Date getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = sdf.format(new Date());
		Date nowDate = new Date();
		try {
			nowDate = sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nowDate;
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	/*
	 * 将Unix时间戳转换成指定格式日期
	 */
	public static String dateToStamp(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date(Long.valueOf(s + "000")));
		return date;

	}

	/**
	 * 获取两个日期之间的实际天数，支持跨年
	 */
	public int getDaysBetween(Calendar start, Calendar end) {
		if (start.after(end)) {
			Calendar swap = start;
			start = end;
			end = swap;
		}
		int days = end.get(Calendar.DAY_OF_YEAR)
				- start.get(Calendar.DAY_OF_YEAR);
		int y2 = end.get(Calendar.YEAR);
		if (start.get(Calendar.YEAR) != y2) {
			start = (Calendar) start.clone();
			do {
				days += start.getActualMaximum(Calendar.DAY_OF_YEAR);
				start.add(Calendar.YEAR, 1);
			} while (start.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	/**
	 * 将时间转为毫秒
	 * 
	 * @author 王兴龙
	 * @date 2017年8月10日
	 * @param inVal
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static long fromDateStringToLong(String inVal) { // 此方法计算时间毫秒
		Date date = null; // 定义时间类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(inVal); // 将字符型转换成日期型
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date.getTime(); // 返回毫秒数
	}

	/**
	 * 获取2个时间的小时差
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static Double getHoursBetween(Date start, Date end) {
		if (start.after(end)) {
			Date swap = start;
			start = end;
			end = swap;
		}
		long btime = end.getTime() - start.getTime();
		return ArithUtil.div(btime+"", "3600000");
	}

	/**
	 * 判断是否超过24小时
	 * @return
	 * @throws Exception
	 */
	public static boolean judgmentDate(Date start, Date end) throws Exception {
		long cha = end.getTime() - start.getTime();
		double result = cha * 1.0 / (1000 * 60 * 60);
		if (result <= 24) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 获得一定小时之后的时间
	 * 
	 * @param time
	 *            传入的时间
	 * @param hours
	 *            多少小时之后
	 * @return
	 */
	public static Date get24Time(Date time, String hours) {
		long curren = time.getTime();
		curren += Double.parseDouble(hours) * (60 * 60 * 1000);
		Date da = new Date(curren);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			return dateFormat.parse(dateFormat.format(da));
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 日期相减(返回秒值)
	 * 
	 * @param date
	 *            Date
	 * @param date1
	 *            Date
	 * @return int
	 * @author
	 */
	public static Long diffDateTime(Date date, Date date1) {
		return (Long) ((getMillis(date) - getMillis(date1)) / 1000);
	}

	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 获取 指定日期 后 指定毫秒后的 Date
	 * 
	 * @param date
	 * @param millSecond
	 * @return
	 */
	public static Date getDateAddMillSecond(Date date, int millSecond) {
		Calendar cal = Calendar.getInstance();
		if (null != date) {// 没有 就取当前时间
			cal.setTime(date);
		}
		cal.add(Calendar.MILLISECOND, millSecond);
		return cal.getTime();
	}
    
	/**
	 * 判断日期是否是当天
	 * @author  dy
	 * @date 2017年11月27日
	 * @param date
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isToday(Date date){
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
		if(fmt.format(date).toString().equals(fmt.format(new Date()).toString())){//格式化为相同格式
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 当天2点传0   次日传1  往后累加
	 * @author  dy
	 * @date 2017年11月27日
	 * @param d   
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
//	public static Date getStartTime(int d,int start) {
//		GregorianCalendar ca = new GregorianCalendar();
//		int s=0;
//		if(ca.get(GregorianCalendar.AM_PM)==0){
//			s=start;
//		}else{
//			s=start-12;
//		}
//		for (int i = 0; i < d; i++) {
//			s+=24;
//		}
//        Calendar todayStart = Calendar.getInstance();
//        todayStart.set(Calendar.HOUR, s);
//        todayStart.set(Calendar.MINUTE, 0);
//        todayStart.set(Calendar.SECOND, 0);
//        todayStart.set(Calendar.MILLISECOND, 0);
//        return todayStart.getTime();
//    }
	/**
	 * 当天9点传0   次日传1  往后累加
	 * @author  dy
	 * @date 2017年11月27日
	 * @param d   
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static Date getTime(int d,int end) {
		GregorianCalendar ca = new GregorianCalendar();
		int s=0;
		if(ca.get(GregorianCalendar.AM_PM)==0){
			s=end;
		}else{
			s=end-12;
		}
		for (int i = 0; i < d; i++) {
			s+=24;
		}
        Calendar todayStart = Calendar.getInstance();  
        todayStart.set(Calendar.HOUR, s);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0);  
        return todayStart.getTime();  
    }

	/**
	 * 获取小时
	 * @param date
	 * @return
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取目前的分钟数
	 * @return
	 */
	public static int getNowAllMinute(){
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		return hour*60+minute;
	}

	/**
	 * 获取date对应的分钟数
	 * @author gzw
	 * @date 2019.01.14
	 * @return
	 */
	public static int getDateAllMinute(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		return hour*60+minute;
	}

	/**
	 * 获取指定日期所在月份开始的时间戳
	 * @param date 指定日期
	 * @return
	 */
	public static Date getMonthBegin(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		//设置为1号,当前日期既为本月第一天
		c.set(Calendar.DAY_OF_MONTH, 1);
		//将小时至0
		c.set(Calendar.HOUR_OF_DAY, 0);
		//将分钟至0
		c.set(Calendar.MINUTE, 0);
		//将秒至0
		c.set(Calendar.SECOND, 0);
		//将毫秒至0
		c.set(Calendar.MILLISECOND, 0);
		// 获取本月第一天的时间戳
		return c.getTime();
	}

	/**
	 * 获取指定日期所在月份结束的时间戳
	 * @param date 指定日期
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		//设置为当月最后一天
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		//将小时至23
		c.set(Calendar.HOUR_OF_DAY, 23);
		//将分钟至59
		c.set(Calendar.MINUTE, 59);
		//将秒至59
		c.set(Calendar.SECOND, 59);
		//将毫秒至999
		c.set(Calendar.MILLISECOND, 999);
		// 获取本月最后一天的时间戳
		return c.getTime();
	}

	public static Date getBeginTime(int year, int month) {
		YearMonth yearMonth = YearMonth.of(year, month);
		LocalDate localDate = yearMonth.atDay(1);
		LocalDateTime startOfDay = localDate.atStartOfDay();
		ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));

		return Date.from(zonedDateTime.toInstant());
	}

	public static Date getEndTime(int year, int month) {
		YearMonth yearMonth = YearMonth.of(year, month);
		LocalDate endOfMonth = yearMonth.atEndOfMonth();
		LocalDateTime localDateTime = endOfMonth.atTime(23, 59, 59, 999);
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
		return Date.from(zonedDateTime.toInstant());
	}


	public static Map<String,String> getWeekMonthYear(String date) {
		Map<String,String> result =  new HashMap<String,String>();
		Calendar cal = Calendar.getInstance();

		cal.setFirstDayOfWeek(Calendar.MONDAY);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatMon = new SimpleDateFormat("MM");
		SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		cal.setTime(d);
		int month = Integer.valueOf(formatMon.format(d));
		int year = Integer.valueOf(formatYear.format(d));

		int week = cal.get(Calendar.WEEK_OF_YEAR);
		result.put("week", String.valueOf(week));
		result.put("month", String.valueOf(month));
		if(week == 1 && month == 12){
			year = year + 1;
		}
		result.put("year", String.valueOf(year));
		return result;
	}

	/**
	 * 获取某年第一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearFirst(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取某年最后一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearLast(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		return currYearLast;
	}
	public static void main(String[] args) {
		Date yearFirst = getYearFirst(2018);
		Date yearLast = getYearLast(2018);
		System.out.println(yearFirst);
		System.out.println(yearLast);
	}
}
