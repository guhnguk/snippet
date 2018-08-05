package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

public class DateFormat {

	@Test
	public void test() throws ParseException {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
//		Calendar cal = Calendar.getInstance(Locale.US).setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm zzz");
		
		
//		cal.set(2012, 10, 01, 12, 00);
//		Date time = cal.getTime();
//		System.out.println(dateFormat.format(time));
		
		// TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
		// Calendar cal = Calendar.getInstance(zone);
		// // Calendar cal = Calendar.getInstance();
		// cal.set(dateYear.toInt(), dateMon.toInt() - 1, dateMday.toInt(), dateHour.toInt(), dateMin.toInt());
		// Date date = cal.getTime();
		// String format = dateFormat.format(date);
		// System.out.println(format);

//		Date date1 = new Date();
//		System.out.println(date1);
//
//		
//		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
//		TimeZone.setDefault(timeZone);
//		timeZone.getDisplayName(Boolean.TRUE, 1, Locale.US);
//		//TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
//		// or pass in a command line arg: -Duser.timezone="UTC"
//
//		Date date2 = new Date();
//		System.out.println(date2);
		
		
		

//		Calendar calendar = Calendar.getInstance();
//		TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
//		calendar.setTimeZone(tz);
//		System.out.println("Offset from UTC=" + tz.getOffset(calendar.getTimeInMillis()) / (60 * 60 * 1000)); // prints
//																												// -8
//		System.out.println(tz.getDisplayName(Boolean.TRUE, 0)); // prints PDT
//		System.out.println(tz.getDisplayName(Boolean.TRUE, 1)); // prints Pacific Daylight Time
//		System.out.println(tz.getDisplayName(Boolean.FALSE, 0));// prints PST
//		System.out.println(tz.getDisplayName(Boolean.FALSE, 1));// prints Pacific Standard Time
	}

}
