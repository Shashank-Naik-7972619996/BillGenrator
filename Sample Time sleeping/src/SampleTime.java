import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SampleTime {

	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		for(int i=0;i<=5;i++) {
			//long start = System.currentTimeMillis();
			
			CurrentTimeDateCalendar.getCurrentDate();System.out.println(CurrentTimeDateCalendar.getCurrentTime()+" This is Starting \n ");
		//Thread.sleep(60000);
		String a=CurrentTimeDateCalendar.getCurrentTime();
		Thread.sleep(RandomSleep.getMillis());
		CurrentTimeDateCalendar.getCurrentDate();System.out.println(CurrentTimeDateCalendar.getCurrentTime()+" Completed at: ");
		String b=CurrentTimeDateCalendar.getCurrentTime();
		System.out.println("Time difference:"+CurrentTimeDateCalendar.timeDifference(a,b)+"\n ");
		
		
		}
		//long end = System.currentTimeMillis();
		//float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
		
	}

}
