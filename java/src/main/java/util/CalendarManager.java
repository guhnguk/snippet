package util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarManager {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(Locale.KOREA);
		
		
		cal.setTime(new Date());
		
		int i = cal.get(cal.DAY_OF_MONTH);
		System.out.println(i);

//		cal.set(Calendar.YEAR, 2009);
//		cal.set(Calendar.MONTH, Calendar.DECEMBER);
//		cal.set(Calendar.DATE, 24);
//
//		cal.add(Calendar.DATE, -100);
//
//		System.out.println(cal.get(Calendar.YEAR) + "년");
//		System.out.println(cal.get(Calendar.MONTH) + 1 + "월");
//		System.out.println(cal.get(Calendar.DATE) + "일");
//
//		cal.set(Calendar.YEAR, 2009);
//		cal.set(Calendar.MONTH, Calendar.DECEMBER);
//		cal.set(Calendar.DATE, 24);
//
//		cal.add(Calendar.MONTH, 4);
//
//		System.out.println(cal.get(Calendar.YEAR) + "년");
//		System.out.println(cal.get(Calendar.MONTH) + 1 + "월");
//		System.out.println(cal.get(Calendar.DATE) + "일");

	}
}
