import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.StringJoiner;

public class CurrentTimeDateCalendar {

		// TODO Auto-generated method stub
		public static String getCurrentTime() {
	        Date date = new Date();
	        String strDateFormat = "hh:mm:ss";
	        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	        String formattedDate= dateFormat.format(date);
	        //System.out.println(formattedDate);
			return formattedDate;
	    }
		
		public static String getCurrentDate() {
			Date date = new Date();
	        String strDateFormat = "dd/MM/yyyy";
	        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	        String formattedDate= dateFormat.format(date);
	        System.out.println(formattedDate);
			return formattedDate;
	    }
		
		
		
		public static String timeDifference(String startTime, String endTime) {
		    LocalTime initialTime = LocalTime.parse(startTime);
		    LocalTime finalTime =LocalTime.parse(endTime);
		    StringJoiner joiner = new StringJoiner(":");
		    long hours = initialTime.until( finalTime, ChronoUnit.HOURS);
		    initialTime = initialTime.plusHours( hours );
		    long minutes = initialTime.until(finalTime, ChronoUnit.MINUTES);
		    initialTime = initialTime.plusMinutes( minutes );
		    long seconds = initialTime.until( finalTime, ChronoUnit.SECONDS);
		    joiner.add(String.valueOf(hours));
		    joiner.add(String.valueOf(minutes));
		    joiner.add(String.valueOf(seconds));
		    return joiner.toString();
		}
		
		
	}