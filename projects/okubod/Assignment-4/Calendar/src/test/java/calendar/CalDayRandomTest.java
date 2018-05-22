package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
   private static final long TestTimeout = 60 * 500;
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
	     long startTime = Calendar.getInstance().getTimeInMillis();
	     long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 
		 GregorianCalendar date = new GregorianCalendar();
		 CalDay cal = new CalDay(date);

	     System.out.println("Start testing of CalDay...");

	     try{
			 for (int iteration=0; elapsed < TestTimeout; iteration++){
				 long randomSeed = System.currentTimeMillis();
				 Random random = new Random(randomSeed);
				 
				 int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 100);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 100);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 0, 100);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 0, 100);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				 String title="Appointment Name";
				 String description="This is an appointment.";
				 String emailAddress="myEmail@someEmail.com";
				 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
				 appt.setValid();
				 //if(!appt.getValid()){System.out.println("Appointment invalid");}
				 cal.addAppt(appt);
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 /*if((iteration%10000)==0 && iteration!=0){
					 System.out.println("Elapsed time: " + elapsed + " of " + TestTimeout);
				 }*/
			 }
		 }catch(NullPointerException e){}
		 
		 System.out.println("Done testing CalDay...");
	 }
}
