/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
	  assertNull(appt0.getXmlElement());
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
	 Appt appt1 = new Appt(10, 0, 1, 1, 2018, null, null, null);
	 assertEquals(10, appt1.getStartHour());
	 assertEquals(0, appt1.getStartMinute());
	 assertEquals(1, appt1.getStartMonth());
	 assertEquals(1, appt1.getStartDay());
	 assertEquals(2018, appt1.getStartYear());
	 assertEquals("", appt1.getTitle());
	 assertEquals("", appt1.getDescription());
	 assertEquals("", appt1.getEmailAddress());
	 appt1.setStartMonth(100);
	 appt1.setValid();
	 String invalidAppt = appt1.toString();
}

@Test(timeout = 4000)
public void test02() throws Throwable {
	Appt appt2 = new Appt(0, 0, 0, null, null, null);
	assertFalse(appt2.hasTimeSet());
	assertTrue(appt2.getValid());
	//Month
	appt2.setStartMonth(13);
	appt2.setValid(); //wrong month valid = false
	assertFalse(appt2.getValid());
	appt2.setStartMonth(0);
	appt2.setValid(); //wrong month valid = false
	assertFalse(appt2.getValid());
	/*appt2.setStartMonth(9);
	appt2.setValid(); //correct month
	assertFalse(appt2.getValid());*/
	appt2.setStartMonth(1); //correct month
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartMonth(12); //correct month continue
	appt2.setValid();
	assertFalse(appt2.getValid());
	//Hour
	appt2.setStartHour(24); // wrong hour valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartHour(-1); // wrong hour valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartHour(0); // correct hour
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartHour(23); // correct hour
	appt2.setValid();
	assertFalse(appt2.getValid());
	/*appt2.setStartHour(15); //correct hour continue
	appt2.setValid();
	assertFalse(appt2.getValid());*/
	//Minute
	appt2.setStartMinute(60); // wrong minute valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartMinute(-1); // wrong minute valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartMinute(0); //correct minute continue
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartMinute(59); //correct minute continue
	appt2.setValid();
	assertFalse(appt2.getValid());
	/*appt2.setStartMinute(59); //correct minute continue
	appt2.setValid();
	assertFalse(appt2.getValid());*/
	//Year
	appt2.setStartYear(-1); // wrong year valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartYear(0); // wrong year valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartYear(2017); //correct year continue
	appt2.setValid();
	assertFalse(appt2.getValid());
	//Day
	appt2.setStartDay(32); //wrong day valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartDay(0); //wrong day valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartDay(CalendarUtil.NumDaysInMonth(2017, 12 - 1)); //correct day continue
	appt2.setValid();
	assertTrue(appt2.hasTimeSet());
	appt2.setStartDay(1); //correct day continue
	appt2.setValid();
	assertTrue(appt2.hasTimeSet());
}

@Test(timeout = 4000)
 public void test03()  throws Throwable  {
	 Appt appt3 = new Appt(15, 30, 9, 14, 2018, null, null, null);
	 assertTrue(appt3.isOn(9, 14, 2018));
	 assertFalse(appt3.isOn(9, 14, 2017));
	 assertFalse(appt3.isOn(10, 14, 2017));
	 assertFalse(appt3.isOn(10, 14, 2018));
	 assertFalse(appt3.isOn(10, 15, 2017));
	 assertFalse(appt3.isOn(10, 15, 2018));
	 assertFalse(appt3.isOn(9, 15, 2018));
	 assertFalse(appt3.isOn(9, 15, 2017));
}

@Test(timeout = 4000)
 public void test04()  throws Throwable  {
	 Appt appt4 = new Appt(15, 30, 9, 14, 2018, null, null, null);
	 int[] recurr = new int[0];
	 appt4.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
	 assertArrayEquals(recurr, appt4.getRecurDays());
	 assertEquals(1, appt4.getRecurBy());
	 assertEquals(1, appt4.getRecurIncrement());
	 assertEquals(1000, appt4.getRecurNumber());
	 assertTrue(appt4.isRecurring());
}

@Test(timeout = 4000)
public void test05() throws Throwable {
	Appt appt5 = new Appt(15, 30, 1, 1, 1, null, null, null);
	assertTrue(appt5.getValid());
	appt5.setStartMonth(0);
	appt5.setValid();
	assertFalse(appt5.getValid());
	appt5.setStartMonth(13);
	appt5.setValid();
	assertFalse(appt5.getValid());
	appt5.setStartMonth(12);
	appt5.setValid();
	assertTrue(appt5.getValid());
}

@Test(timeout = 4000)
public void test06() throws Throwable {
	Appt appt6 = new Appt(0, 0, 1, 1, 1, null, null, null);
	assertTrue(appt6.getValid());
	appt6.setStartHour(-1);
	appt6.setValid();
	assertFalse(appt6.getValid());
	appt6.setStartHour(24);
	appt6.setValid();
	assertFalse(appt6.getValid());
	appt6.setStartHour(23);
	appt6.setValid();
	assertTrue(appt6.getValid());

}

@Test(timeout = 4000)
public void test07() throws Throwable {
	Appt appt7 = new Appt(0, 0, 1, 1, 1, null, null, null);
	assertTrue(appt7.getValid());
	appt7.setStartMinute(-1);
	appt7.setValid();
	assertFalse(appt7.getValid());
	appt7.setStartMinute(60);
	appt7.setValid();
	assertFalse(appt7.getValid());
	appt7.setStartMinute(59);
	appt7.setValid();
	assertTrue(appt7.getValid());

}

@Test(timeout = 4000)
public void test08() throws Throwable {
	Appt appt8 = new Appt(0, 0, 1, 1, 1, null, null, null);
	assertTrue(appt8.getValid());
	appt8.setStartYear(-1);
	appt8.setValid();
	assertFalse(appt8.getValid());
	appt8.setStartYear(0);
	appt8.setValid();
	assertFalse(appt8.getValid());
	appt8.setStartYear(2018);
	appt8.setValid();
	assertTrue(appt8.getValid());

}

@Test(timeout = 4000)
public void test09() throws Throwable {
	Appt appt9 = new Appt(0, 0, 1, 1, 1, null, null, null);
	assertTrue(appt9.getValid());
	appt9.setStartDay(0);
	appt9.setValid();
	assertFalse(appt9.getValid());
	appt9.setStartDay(CalendarUtil.NumDaysInMonth(appt9.getStartYear(), appt9.getStartMonth() - 1)+1);
	appt9.setValid();
	assertFalse(appt9.getValid());
	appt9.setStartDay(CalendarUtil.NumDaysInMonth(appt9.getStartYear(), appt9.getStartMonth() - 1));
	appt9.setValid();
	assertTrue(appt9.getValid());

}

}
