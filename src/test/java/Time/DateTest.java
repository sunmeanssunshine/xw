package Time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

/**
 * Created by xuwei on 2017/12/19.
 */
public class DateTest {
    @Test
    public void test1() {
        //该方法被废弃，不要使用，从1900开始， 月份从0开始
        Date date = new Date(114, 2, 18);
        System.out.println(date.toString());

        Date date1 = new Date(System.nanoTime());
        System.out.println(date1);
    }

    @Test
    public void test3() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        LocalDate today = LocalDate.now();
        System.out.println("year:" + year);
        System.out.println("month:" + month);
        System.out.println("day:" + day);
        System.out.println("dow:" + dow);
        System.out.println("len:" + len);
        System.out.println("leap:" + leap);
        System.out.println("today:" + today);

        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println("hour:" + hour);
        System.out.println("minute:" + minute);
        System.out.println("second:" + second);
    }
}
