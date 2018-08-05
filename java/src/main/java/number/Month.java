package number;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import util.DateUtil;

public class Month {
	private String[] month = new String[] { "01", "", "", "" };

	@Test
	public void testAddDate() throws Exception {
		String startDate = "20121001";
		String endDate = "20121031";

		String year = getYear(startDate);
		String month = getMonth(startDate);
		String day = getDay(startDate);

		int startNumDate = Integer.parseInt(startDate);
		int endNumDate = Integer.parseInt(endDate);

		while ((endNumDate - startNumDate) >= 0) {

		}
	}

	private String getYear(String startDate) {
		return startDate.substring(0, 4);
	}

	private String getMonth(String startDate) {
		return startDate.substring(4, 6);
	}

	private String getDay(String startDate) {
		return startDate.substring(5, 7);
	}

	@Test
	public void test() {
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 10, 01);
		int i = cal.get(Calendar.MONTH);
		System.out.println(i);

		int maximum = Calendar.getInstance().getActualMaximum(Calendar.DATE);
		System.out.println(maximum);
	}

	@Test
	public void testCalendarList() throws Exception {
		String start = "20121001";
		String end = "20121031";

		Integer startNumMonth = Integer.valueOf(getMonth(start));
		Calendar startDate = Calendar.getInstance();
		startDate.set(2012, startNumMonth - 1, 01);

		Integer endNumMonth = Integer.valueOf(getMonth(end));
		Calendar endDate = Calendar.getInstance();
		endDate.set(2013, endNumMonth - 1, 31);

		long dayMills = 86400000;
		for (long startMills = startDate.getTimeInMillis(), endMills = endDate.getTimeInMillis(); startMills <= endMills;) {
			String strYear = String.valueOf(startDate.get(Calendar.YEAR));

			int monthNum = (startDate.get(Calendar.MONTH) + 1);
			String strMonth = null;
			if (monthNum < 10) {
				strMonth = "0" + String.valueOf(monthNum);
			} else {
				strMonth = String.valueOf(monthNum);
			}

			int dateNum = startDate.get(Calendar.DATE);
			String strDate = null;
			if (dateNum < 10) {
				strDate = "0" + String.valueOf(dateNum);
			} else {
				strDate = String.valueOf(dateNum);
			}

			System.out.println(strYear + strMonth + strDate);
			startMills += dayMills;
			startDate.setTimeInMillis(startMills);
		}
	}
}
