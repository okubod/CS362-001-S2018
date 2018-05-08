
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  GregorianCalendar fday = new GregorianCalendar(2018, 11, 1);
	  GregorianCalendar lday = new GregorianCalendar(2018, 11, 12);
	  DataHandler dh0 = new DataHandler();
	  assertTrue(dh0.save());
	  Appt appt0 = new Appt(0, 0, 10, 12, 2018, null, null, null);
	  Appt appt05 = new Appt(15, 9, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  Appt appt02 = new Appt(15, 11, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      Appt appt03 = new Appt(15, 13, 10, 12, 2018, null, null, null);
	  Appt appt01 = new Appt(5, 5, 2018, null, null, null);
	  appt01.setValid();
	  assertTrue(dh0.saveAppt(appt0));
	  assertTrue(dh0.saveAppt(appt05));
	  assertTrue(dh0.saveAppt(appt02));
	  assertTrue(dh0.saveAppt(appt03));
	  assertFalse(dh0.saveAppt(appt01));
	  dh0.getApptRange(fday, lday);
	  assertFalse(dh0.deleteAppt(appt01));
	  assertTrue(dh0.deleteAppt(appt0));
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  GregorianCalendar fday = new GregorianCalendar(2018, 11, 1);
	  GregorianCalendar lday = new GregorianCalendar(2018, 11, 12);
	  DataHandler dh1 = new DataHandler("calendar.xml");
	  Appt appt1 = new Appt(0, 0, 10, 12, 2018, null, null, null);
	  dh1.saveAppt(appt1);
    //System.out.println(dh1.getApptRange(fday, lday));

  }
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
	  GregorianCalendar fday = new GregorianCalendar(2018, 0, 1);
	  GregorianCalendar lday = new GregorianCalendar(2019, 11, 25);
	  DataHandler dh2 = new DataHandler("calendar.xml", false);
	  int[] recurr = {2};
	  Appt appt2 = new Appt(0, 0, 10, 12, 2018, null, null, null);
	  Appt appt21 = new Appt(0, 0, 11, 12, 2018, null, null, null);
	  Appt appt22 = new Appt(0, 0, 12, 12, 2018, null, null, null);
	  Appt appt23 = new Appt(0, 0, 13, 12, 2018, null, null, null);
	  appt2.setRecurrence(recurr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
	  appt21.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
	  appt22.setRecurrence(null, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
	  appt23.setRecurrence(null, Appt.RECUR_BY_YEARLY, 1, Appt.RECUR_NUMBER_FOREVER);
	  assertTrue(dh2.saveAppt(appt2));
	  assertTrue(dh2.saveAppt(appt21));
	  assertTrue(dh2.saveAppt(appt22));
	  assertTrue(dh2.saveAppt(appt23));
	  dh2.getApptRange(fday, lday);
	  assertTrue(dh2.deleteAppt(appt2));

  }
    @Test(timeout = 4000)
  public void test03()  throws Throwable  {
    GregorianCalendar fday = new GregorianCalendar(2018, 0, 1);
	  GregorianCalendar lday = new GregorianCalendar(2018, 0, 2);
	  DataHandler dh3 = new DataHandler("calendaria.xml");
    //System.out.println(dh3.getApptRange(fday, lday));
    //assertEquals(dh3.getCalDays(), dh3.getApptRange(fday, lday));
  }
}
