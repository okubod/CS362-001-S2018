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
      assertEquals("\t14/9/2018 at 18:15pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
	  assertNull(appt0.getXmlElement());
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
	 Appt appt1 = new Appt(10, 0, 1, 1, 2018, null, null, null);
	 assertEquals(0, appt1.getStartHour());
	 assertEquals(10, appt1.getStartMinute());
	 assertEquals(1, appt1.getStartMonth());
	 assertEquals(1, appt1.getStartDay());
	 assertEquals(2018, appt1.getStartYear());
	 assertEquals("", appt1.getTitle());
	 assertEquals("", appt1.getDescription());
	 assertEquals("", appt1.getEmailAddress());
	 appt1.setStartMonth(5);
	 appt1.setValid();
	 String invalidAppt = appt1.toString();
}

@Test(timeout = 4000)
public void test02() throws Throwable {
	Appt appt2 = new Appt(0, 0, 0, null, null, null);
	assertFalse(appt2.hasTimeSet());
	assertTrue(appt2.getValid());
	appt2.setStartMonth(9);
	appt2.setValid(); //wrong month valid = false
	assertFalse(appt2.getValid());
	appt2.setStartMonth(0); //correct month continue
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartMonth(12); //correct month continue
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartHour(24); // wrong hour valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartHour(15); //correct hour continue
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartMinute(60); // wrong minute valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartMinute(30); //correct minute continue
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartYear(-1); // wrong year valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartYear(2017); //correct year continue
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartDay(32); //wrong day valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartDay(0); //wrong day valid = false
	appt2.setValid();
	assertFalse(appt2.getValid());
	appt2.setStartDay(14); //correct day continue
	appt2.setValid();
	assertTrue(appt2.hasTimeSet());
}

@Test(timeout = 4000)
 public void test03()  throws Throwable  {
	 Appt appt3 = new Appt(15, 30, 9, 14, 2018, null, null, null);
	 assertTrue(appt3.isOn(14, 9, 2018));
	 assertFalse(appt3.isOn(14, 9, 2017));
	 assertFalse(appt3.isOn(14, 10, 2017));
	 assertFalse(appt3.isOn(14, 10, 2018));
	 assertFalse(appt3.isOn(15, 10, 2017));
	 assertFalse(appt3.isOn(15, 10, 2018));
	 assertFalse(appt3.isOn(15, 9, 2018));
	 assertFalse(appt3.isOn(15, 9, 2017));
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

}
