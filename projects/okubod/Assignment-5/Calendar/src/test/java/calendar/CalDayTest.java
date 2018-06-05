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
	  assertEquals(1, cal1.getMonth());
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
  @Test(timeout = 4000)
  public void test03() throws Throwable {
	  GregorianCalendar date3 = new GregorianCalendar(2000, 0, 1);
	  CalDay cal3 = new CalDay(date3);
	  Appt appt0 = new Appt(10, 12, 2018, null, null, null);
	  cal3.addAppt(appt0);
	  //cal3.getFullInfomrationApp(cal3);
	  //System.out.println(cal3.getFullInfomrationApp(cal3));
	  assertEquals("1-1-2000 \n\t  ", cal3.getFullInfomrationApp(cal3));
  }
  @Test(timeout = 4000)
  public void test04() throws Throwable {
	  GregorianCalendar date4 = new GregorianCalendar(2000, 0, 1);
	  CalDay cal4 = new CalDay(date4);
	  Appt appt01 = new Appt(1, 0, 10, 12, 2018, null, null, null);
	  int apptSize = cal4.getAppts().size();
	  cal4.addAppt(appt01);
	  assertEquals(apptSize+1, cal4.getAppts().size());
	  cal4.getFullInfomrationApp(cal4);
	  //String test = cal4.toString().replace("\t", "\\t").replace("\n", "\\n");
	  //System.out.println(test);
	  assertEquals("\t --- 2/1/2000 --- \n --- -------- Appointments ------------ --- \n\t12/10/2018 at 1:0am ,, \n \n", cal4.toString());
  }
  @Test(timeout = 4000)
  public void test05() throws Throwable {
	  GregorianCalendar date5 = new GregorianCalendar(2000, 0, 1);
	  CalDay cal5 = new CalDay(date5);
	  Appt appt01 = new Appt(12, 10, 10, 12, 2018, null, null, null);
	  cal5.addAppt(appt01);
	  //System.out.println(cal5.getFullInfomrationApp(cal5));
	  assertEquals("1-1-2000 \n\t0:10AM   ", cal5.getFullInfomrationApp(cal5));
  }

}
