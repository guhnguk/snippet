package date.time;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import util.DateUtil;

public class NearestTimeFinderTest {

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  @Test
  public void testNearestTime() throws Exception {
    DateTime today = new DateTime();
    System.out.println("Today: " + today);
    DateTime yesturday = today.minusDays(1);
    System.out.println("Yesturday: " + yesturday);

    Duration duration = new Duration(yesturday, today);
    System.out.println("Day diff: " + duration.getStandardDays());
    System.out.println("Hour diff: " + duration.getStandardHours());
    System.out.println("Min diff: " + duration.getStandardMinutes());
  }

  @Test
  public void testFineNearestTime() throws Exception {
    String basisTime = "2013-12-11 13:22:01.0";
    String time1 = "2013-12-11 13:22:45.0";
    String time2 = "2013-12-10 13:22:45.0";
    String time3 = "2013-12-10 17:22:45.0";
    
    
    String subBasis = basisTime.substring(0, 10);
    System.out.println(subBasis);
    String substring = basisTime.substring(11, basisTime.length());
    System.out.println(substring);
    
    String subTime1 = time1.substring(0, 10);
    String subTime2 = time2.substring(0, 10);
    String subTime3 = time3.substring(0, 10);
    
    
    

    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");

    DateTime basisDateTime = formatter.parseDateTime(basisTime);
    DateTime iTime1 = formatter.parseDateTime(time1);
    DateTime iTime2 = formatter.parseDateTime(time2);
    DateTime iTime3 = formatter.parseDateTime(time3);

    System.out.println("Diff with iTime1 --> " + Math.abs(Seconds.secondsBetween(basisDateTime, iTime1).getSeconds()));
    System.out.println("Diff with iTime2 --> " + Math.abs(Seconds.secondsBetween(basisDateTime, iTime2).getSeconds()));
    System.out.println("Diff with iTime3 --> " + Math.abs(Seconds.secondsBetween(basisDateTime, iTime3).getSeconds()));

    List<Integer> times = new ArrayList<Integer>();
    times.add(Math.abs(Seconds.secondsBetween(basisDateTime, iTime1).getSeconds()));
    times.add(Math.abs(Seconds.secondsBetween(basisDateTime, iTime2).getSeconds()));
    times.add(Math.abs(Seconds.secondsBetween(basisDateTime, iTime3).getSeconds()));
    
    int min = Integer.MAX_VALUE;
    for (Integer diff : times) {
      if (diff < min) {
        min = diff;
      }
    }
    
    System.out.println(min);
    
//    for (int i = 0; i < 3; i++) {
//      int diff = Math.abs(Seconds.secondsBetween(basisDateTime, iTime1).getSeconds());
//      if (diff < min) {
//        min = diff;
//      }
//    }

    // long current = b.getTime();
    // int index = -1;
    // for (int i = 0; i < a.length; i++) {
    // long diff = Math.abs(current - a.getTime());
    // if (diff < min) {
    // min = diff;
    // index = i;
    // }
    // }
  }
}
