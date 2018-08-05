package number;

import static org.junit.Assert.*;

import org.junit.Test;

public class LatitudeLongitude {

	@Test
	public void test() {
		int initLat = 0;
		int initLog = 0;
		
		int maxLat = 5;
		int maxLog = 5;
		int minLat = initLat;
		int minLog = initLog;
		
		while (true) {
			System.out.println(minLat + "," + minLog);
			
			minLog += 1;
			if (minLog > maxLog) {
				minLat += 1;
				minLog = initLog; 
			}
			
			if (minLat > maxLat) {
				break;
			}
			
		}
	}
}
