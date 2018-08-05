package thread;

import java.io.PrintStream;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleTester {

	public static void main(String[] args) {
		// Get the scheduler
		// ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

		// Get a handle, starting now, with a 10 second delay
		ScheduledFuture<?> timeHandle = null;
		for (int i = 0; i < 5; i++) {
			timeHandle = scheduler.scheduleAtFixedRate(new TimePrinter(System.out), 0, 2, TimeUnit.SECONDS);
		}

		// Schedule the event, and run for 1 hour (60 * 60 seconds)
//		scheduler.schedule(new Runnable() {
//			public void run() {
//				timeHandle.cancel(false);
//			}
//		}, 60 * 60, TimeUnit.SECONDS);

		/**
		 * On some platforms, you'll have to setup this infinite loop to see output while (true) { }
		 */
	}
}

class TimePrinter implements Runnable {

	private PrintStream out;

	public TimePrinter(PrintStream out) {
		this.out = out;
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		out.printf("#" + threadName + " Current time: %tr%n", new Date());
	}
}
