/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;

public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  GregorianCalendar date0 = new GregorianCalendar(2000, 0, 1);
	  CalDay cal0 = new CalDay(date0);
	  assertTrue(cal0.isValid());
	  Appt appt0 = new Appt(15, 10, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  Appt appt01 = new Appt(15, 9, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  Appt appt02 = new Appt(15, 11, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      Appt appt03 = new Appt(15, 13, 10, 12, 2018, null, null, null);
	  Appt appt04 = new Appt(0, 0, 10, 14, 2018, null, null, null);
	  Appt appt05 = new Appt(5, 5, 2018, null, null, null);
	  appt05.setValid();
      cal0.addAppt(appt0);
      cal0.addAppt(appt01);
      cal0.addAppt(appt02);
	  cal0.addAppt(appt03);
	  cal0.addAppt(appt04);
	  cal0.addAppt(appt05);
	  String cala = cal0.toString();
	  cal0.getFullInfomrationApp(cal0);
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  GregorianCalendar date1 = new GregorianCalendar();
	  date1.clear();
	  CalDay cal1 = new CalDay(date1);
	  assertEquals(1, cal1.getDay());
	  assertEquals(0, cal1.getMonth());
	  assertEquals(1970, cal1.getYear());
	  assertEquals(0, cal1.getSizeAppts());
	  cal1.appts = null;
	  assertNull(cal1.getAppts());

  }
  @Test(timeout = 4000)
  public void test02() throws Throwable {
	  CalDay cal2 = new CalDay();
	  assertFalse(cal2.isValid());
	  assertNull(cal2.iterator());
	  assertEquals("", cal2.toString());
  }
}
