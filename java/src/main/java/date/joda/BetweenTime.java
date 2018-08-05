package date.joda;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;
import org.junit.Test;

public class BetweenTime {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
    public void testConvertString2Date() throws Exception {
	    String ts = "2013-01-14 09:29:58";
	    String date = ts.substring(0, 10);
	    int years = Integer.parseInt(date.substring(0, 4));
	    int months = Integer.parseInt(date.substring(5, 7));
	    int days = Integer.parseInt(date.substring(8, 10));
	    
    }

	@Test
	public void testGetDiffDateOrTime() throws Exception {
		String date1 = "2013-01-14 09:29:58";
		String date2 = "2013-01-15 10:31:48";
	 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date d1 = null;
		Date d2 = null;
	 
		try {
			d1 = format.parse(date1);
			System.out.println(d1);
			d2 = format.parse(date2);
	 
			DateTime dt1 = new DateTime(d1);
			DateTime dt2 = new DateTime(d2);
	 
			int years = Years.yearsBetween(dt1, dt2).getYears();
			int months = Months.monthsBetween(dt1, dt2).getMonths();
			int days = Days.daysBetween(dt1, dt2).getDays();
			int hours = Hours.hoursBetween(dt1, dt2).getHours();
			int minutes = Minutes.minutesBetween(dt1, dt2).getMinutes();
			int seconds = Seconds.secondsBetween(dt1, dt2).getSeconds();
			
			
			if (0 == years) {
				years = dt1.getYear();
			}
			
			Calendar cal = Calendar.getInstance();
			cal.set(years, months, days, hours, minutes, seconds);
			Date gapTime = cal.getTime();
			
			
			int year = cal.get(Calendar.YEAR);
			System.out.println(year);
			System.out.println("## " + gapTime);
			
			System.out.print(years + " years, ");
			System.out.print(months + " monthss, ");
			System.out.print(days + " days, ");
			System.out.print(hours % 24 + " hours, ");
			System.out.print(minutes % 60 + " minutes, ");
			System.out.print(seconds % 60 + " seconds.");
	 
		 } catch (Exception e) {
			fail(e.getMessage());
		 }
	}
}
