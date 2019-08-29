package com.vz.model.utils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtils {

	/**日期时间转化，目标中包含需要转化的时间对象，精确到天
	 * <pre>
	 *     比如存在一个参数 {{yyyyMMdd|-1}}, 则会被替换为 yyyyMMdd格式的昨天
	 * </pre>
	 * @author Administrator
	 * @createTime 2019/8/22
	 * @description
	 * */
	public static String dayTransfer(String target){
		String regexTarget = "\\{\\{([^\\}]+)\\}\\}";

		Pattern p = Pattern.compile(regexTarget);
		Matcher m = p.matcher(target);

		if(m.find()){
			String[] contents = m.group(1).split("\\|");
			int offset = 0;
			if(contents.length > 1){
				try {
					offset = Integer.valueOf(contents[1]);
				}catch (Exception e){
					System.err.println("尝试解析日期格式出现异常，使用默认时间：当天!");
					offset = 0;
				}
			}
			String temp = getDay(offset, contents[0]);
			target = m.replaceFirst(temp);
		}

		return target;
	}
	public static void main(String args[]){
	    String target = "20-APOLLO-bdiloaninfo-2G-{{yyyyMMdd|-1}}-{{yyyyMMdd|-2}}";
		System.out.println(dayTransfer(target));
	}

	/**
	 * 以当前时间为基准，判断时间是否在指定时间之内
	 * @param target 被判断的时间
	 * @param minute 时间范围(分钟)
	 * @return 加入输入的是30，那么当时间在30分钟之前则返回true，否则返回false
	 */
	public static boolean isMinutesAgo(Date target, int minute) {
		if(null == target) return false;
		
		long targetTime = target.getTime();
		
		Date now = new Date();
		
		long nowTime = now.getTime();
		
		return 60000*minute < (nowTime - targetTime);
	}

	public static String getTimeByFormat(String format){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}
	
	public static String getDay(int offset, String format){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, offset);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(calendar.getTime());
	}
	
	
	/**
	 * 依照当前时间，按照偏移量返回一个 date对象
	 * @param offset
	 * @return
	 */
	public static Date getDay(int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, offset);
		return calendar.getTime();
	}
	
	/**并指定格式和偏移量，获取年月
	 * @param offset 如果获取上个月，则传 -1
	 * @format 格式 ,比如yyyyMM
	 * */
	public static String getMonth(int offset, String format){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, offset);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(calendar.getTime());
	}
	
	/**以当前月为基准，获取某个月的指定日期
	 * @param offset 月份偏移量
	 * @param day 指定日期 1~28
	 * */
	public static Date appointMonthDay(int offset, String day){
		String month = getMonth(offset, "yyyy-MM-");
		String appointMonthDay = month+day;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			return sdf.parse(appointMonthDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取基于当前时间的指定某一天
	 * @param offset 日期偏移量
	 * @return
	 */
	public static Date getDayByOffset(int offset) {
		Calendar cale = Calendar.getInstance();
		int day=cale.get(Calendar.DATE);
		cale.set(Calendar.DAY_OF_MONTH	,day+offset);
		return cale.getTime();
	}
	
	/**获取某个月的最后一天
	 * @param offset 以当前月为基准，获取某个月的偏移量
	 * @return yyyy-MM-dd 指定月分的最后一天
	 * <pre>
	 * 比如当前时间为2018-11-06,想要获取2018-10-31.那么需要输入参数-1即可。
	 * 如果想获取当前月最后一天：2018-11-30.那么输入参数0.
	 * </pre>
	 * */
	public static String getLastDay(int offset){
		SimpleDateFormat monthformat = new SimpleDateFormat("MM");
		String thisMonth = monthformat.format(new Date());
		int thisMonthInt = Integer.valueOf(thisMonth);
		int targetMonth = thisMonthInt+offset;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance();   
		cale.set(Calendar.MONTH,targetMonth);
		cale.set(Calendar.DAY_OF_MONTH,0);
		String targetMonthString = format.format(cale.getTime());
		System.out.println(targetMonthString);
		return targetMonthString;
	}
	
	/**保证输出的是贷后使用的日期格式
	 * <pre>
	 * 程序会努力将日期格式变更为yyyyMM
	 * 如果异常，则返回默认值：yyyyMM（上个月）
	 * </pre>
	 * */
	public static String makeSureForDH(String target) {	
		return makeSureForDH(target,-1);
	}
	
	/**
	 * 反馈指定年月，否则返回默认年月
	 * <pre>
	 * 默认年月由偏移量(offset)决定
	 * 如果offset=-1那么默认返回当前时间的上个月
	 * </pre>
	 * */
	public static String makeSureForDH(String target, int offset) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = "";
		try {
			String spiler = target.substring(4, 5);
			if(!Pattern.matches("[0-9]", spiler)){
				yyyyMM = target.replace(spiler, "").substring(0, 6);
			}
			
			String MM = yyyyMM.substring(4, 6);
			int mm = Integer.valueOf(MM);
			if(mm > 12){
				yyyyMM = yyyyMM.substring(0,5);
			}
//			Date date = sdf.parse(yyyyMM);
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(date);
//			calendar.add(Calendar.MONTH, offset);
//			yyyyMM = sdf.format(calendar.getTime());
			Date date = sdf.parse(yyyyMM);
			yyyyMM = sdf.format(date);
		} catch (Exception e) {
			System.err.println("尝试转化日期失败，格式异常:["+target+"]");
			yyyyMM = getMonth(offset,"yyyyMM");
			System.out.println("使用默认时间"+yyyyMM);
		}
		
		return yyyyMM;
	}
	
	/**按照指定的日期格式，创建一个为上个月的时间
	 * @param format
	 * @return format='yyyyMM' 则 201807
	 * */
	public static String getLastMonthByFormat(String format){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		return new SimpleDateFormat(format).format(calendar.getTime());
	}
	
	/**
	 * 指定时间和日期格式
	 * */
	public static String getTimeByFormat(Date date, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return new SimpleDateFormat(format).format(calendar.getTime());
	}

	


}
