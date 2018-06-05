package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 public static int compareDates(int firstYear, int firstMonth, int firstDay, int lastYear, int lastMonth, int lastDay){
		 if(lastYear < firstYear){
			 return 1;
		 }else if(lastYear == firstYear){
			 if(lastMonth < firstMonth){
				 return 1;
			 }else if(lastMonth == firstMonth){
				 if(lastDay < firstDay){
					 return 1;
				 }else{
					 return 0;
				 }
			 }else{
				 return 0;
			 }
		 }else{
			 return 0;
		 }
	 }
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 
		 
		 System.out.println("Start testing of DataHandler...");
		 
		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 DataHandler dh = new DataHandler("calendar.xml");
				 LinkedList<Appt> apptList = new LinkedList<Appt>();
				 long randomseed =System.currentTimeMillis(); //10
	//			 System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);
				 for (int i = 0; i < NUM_TESTS; i++) {
					 int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
					 int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 60);
					 int startDay=ValuesGenerator.getRandomIntBetween(random, 0, 32);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, 0, 12);
					 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
					 String title="Birthday Party";
					 String description="This is my birthday party.";
					 String emailAddress="xyz@gmail.com";
					 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
					 appt.setValid();
					 dh.saveAppt(appt);
					 apptList.add(appt);
				 }
					 int fDay=ValuesGenerator.getRandomIntBetween(random, 1, 29);
					 int fMonth=ValuesGenerator.getRandomIntBetween(random, 1, 6);
					 int fYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
					 int lDay=ValuesGenerator.getRandomIntBetween(random, 1, 29);
					 int lMonth=ValuesGenerator.getRandomIntBetween(random, 7, 12);
					 int lYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
					 int randAppt=ValuesGenerator.getRandomIntBetween(random, 0, NUM_TESTS);
					 GregorianCalendar fday = new GregorianCalendar(fYear, fMonth, fDay);
					 GregorianCalendar lday = new GregorianCalendar(lYear, lMonth, lDay);
					 dh.getApptRange(fday, lday);
					 dh.deleteAppt(apptList.get(randAppt));
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 /*if((iteration%10000)==0 && iteration!=0){
					 System.out.println("Elapsed time: " + elapsed + " of " + TestTimeout);
				 }*/
			 }
		 }catch(NullPointerException e){}
		 
		 System.out.println("Done testing DataHandler...");
	 }
	
}
