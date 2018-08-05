package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class DateUtil {
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public final static String dateFormatString1 = "yyyy-MM-dd HH:mm:ss";
	/**
	 * YYYMMDDHH24MISS
	 */
	public final static String dateFormatString2 = "yyyyMMddHHmmss";
	/**
	 * YYYYMMDD
	 */
	public final static String dateFormatString3 = "yyyyMMdd";

	public final static String dateFormatString4 = "yyyy-MM-dd HH:mm:ss.SSSSSSSSS";
	public final static String dateFormatString5 = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * Return specified parameter format sting of current system time <br>
	 * 지정된 포맷의 파라미터를 받아서서 현재시간을 문자열로 반환한다.
	 * 
	 * @author [2009.09.09] Ryan Ahn
	 * 
	 * @param format
	 *            String format ex) yyyyMMddHHmm
	 * 
	 * @return String
	 */
	public static String getCurrnetTime(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA);
		return formatter.format(new Date());
	}

	/**
	 * Return specified parameter format sting of current system time away from hour parameter <br>
	 * 현재시간을 기준으로 입력받은 시간보다 +/- 셈한 시간을 지정된 포맷의 문자열로 반환한다.
	 * 
	 * @author [2009.09.09] Ryan Ahn
	 * 
	 * @param hour
	 *            time hour
	 * @param format
	 *            String format ex) yyyyMMddHHmm
	 * 
	 * @return String
	 */
	public static String getAwayHourTime(int hour, String format) {
		Date date = new Date();

		Date awayDate = new Date();
		awayDate.setTime(date.getTime() - 3600000L * (long) hour);
		SimpleDateFormat simpledateformat = new SimpleDateFormat(format, Locale.KOREA);

		return simpledateformat.format(awayDate);
	}

	public static void main(String[] args) {
		System.out.println(getWantTime(new Date(), dateFormatString1));
		System.out.println(getCurrnetTime(dateFormatString1));
		System.out.println(getCurrnetTime(dateFormatString2));
		System.out.println(getCurrnetTime(dateFormatString3));
		System.out.println(getCurrnetTime(dateFormatString4));
		System.out.println(getCurrnetTime(dateFormatString5));

		// System.out.println( getAwayHourTime( 1, dateFormatString1 ) );
	}

	public static String getWantTime(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA);
		return formatter.format(date);
	}

	public static String epochtimeToDate(String epochTime) {
		String[] epochTimes = Iterables.toArray(Splitter.on(".").trimResults().split(epochTime), String.class);
		long prefixEpochTime = Long.parseLong(epochTimes[0]) * 1000;
		String date = new SimpleDateFormat(dateFormatString2, Locale.KOREA).format(new Date(prefixEpochTime));

		return date + "." + epochTimes[1];
	}
}
