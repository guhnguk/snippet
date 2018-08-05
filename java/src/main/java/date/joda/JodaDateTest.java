package date.joda;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

public class JodaDateTest {

    @Test
    public void testAddDays() throws Exception {
        String date1 = "2013-01-14 09:29:58";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = format.parse(date1);

        DateTime dateTime = new DateTime(d1);
        dateTime = dateTime.plusDays(1);
        System.out.println(dateTime);
    }

    @Test
    public void testTimeZone() throws Exception {
        // get current moment in default time zone
        DateTime dt = new DateTime(2013, 10, 01, 12, 00, DateTimeZone.forID("America/Los_Angeles"));
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        String string = dt.toString(fmt);
        System.out.println(string);

        // translate to London local time
        DateTime dtLa = dt.withZone(DateTimeZone.forID("America/Los_Angeles"));
        System.out.println(dtLa);

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        DateTime date = new DateTime();
        DateTime startTime = new DateTime(2012, 10, 01, 12, 00, DateTimeZone.forID("America/Los_Angeles"));
        DateTime endTime = new DateTime(2013, 10, 31, 12, 00, DateTimeZone.forID("America/Los_Angeles"));

        // for (int i = 0; i < 1; i++) {
        // int dayOfMonth = dateTime.dayOfMonth().getMaximumValue();
        // System.out.println(dateTime.toString(format));
        // System.out.println(dayOfMonth);
        // }
    }

    @Test
    public void testPlusDate() throws Exception {
        String strDate = "2013-01-14 09:29:58.0";
        
        String substring2 = strDate.substring(strDate.lastIndexOf(".") + 1, strDate.length());
        System.out.println(substring2);

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");
        DateTime parsedDateTime = format.parseDateTime(strDate);
        DateTime dateTime = new DateTime(parsedDateTime);

        System.out.println(dateTime);

        DateTime plusMillis = dateTime.plusMillis(3);
        System.out.println(plusMillis);

        DateTime plusSeconds = dateTime.plusSeconds(3);
        System.out.println(plusSeconds);

        DateTime plusMinutes = dateTime.plusMinutes(3);
        System.out.println(plusMinutes);

        DateTime plusHours = dateTime.plusHours(3);
        System.out.println(plusHours);

        DateTime plusDays = dateTime.plusDays(3);
        System.out.println(plusDays);

        DateTime plusWeeks = dateTime.plusWeeks(3);
        System.out.println(plusWeeks);

        DateTime plusMonths = dateTime.plusMonths(3);
        System.out.println(plusMonths);

        DateTime plusYears = dateTime.plusYears(3);
        System.out.println(plusYears);

        String strPlus = dateTime.plusMillis(3).toString();
        String substring = strPlus.substring(strPlus.lastIndexOf(".")+1, strPlus.length());
        System.out.println(substring);
    }
}
