package date;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by xuwei on 2018/3/6.
 */
public class Demo {
    @Test
    public void testLocalDate() {
        System.out.println(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()).getTime());
        System.out.println(Date.from(LocalDate.of(2018,3,6).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()).getTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDate.of(2018, 10,21));
    }

    @Test
    public void test2() {
        List<Demo1> demos = Lists.newArrayList(new Demo1("1", "1", 1L),
                new Demo1("2", "1", 2L),
                new Demo1("3", "2", 2L),
                new Demo1("4", "3", 3L),
                new Demo1("5", "3", 1L),
                new Demo1("6", "3", 4L),
                new Demo1("7", "4", 6L),
                new Demo1("8", "6", 8L));
        Map<String, Long> map = demos.stream().collect(Collectors.toMap(Demo1::getKey, Demo1::getValue));
        System.out.println("");
    }

    @Test
    public void test3() {
        System.out.println(new Date().toInstant().atZone(ZoneId.systemDefault()));
    }

    @Test
    public void test4() {
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 0, 1, 0, 0, 0);
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        long intervalMilli = System.nanoTime() - cal.getTimeInMillis();
        System.out.println( intervalMilli / (24 * 60 * 60 * 1000));

    }

    @Test
    public void test5() {
        Date date = new Date(System.currentTimeMillis());
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date date1 = new Date(System.currentTimeMillis() + 500);
        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        System.out.println(localDate.isEqual(localDate1));

        //Map<Integer, String> map =
        //Arrays.asList(1,2,3,4).stream().collect(Collectors.toMap(Function.identity(), "1" + Function.identity()));
        System.out.println(5L / (double)2L);

        //IntStream.range(0, 7).map(e -> ImmutableMap.builder().put(LocalDate.now().minusDays(e), e).build());

    }

    @Test
    public void test6() {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "1");
        System.out.println(LocalDate.now().atStartOfDay());
        System.out.println(LocalDate.now().atStartOfDay().plusMinutes(30L));

        LocalDateTime dateTime = LocalDate.now().atStartOfDay();
        //Date date = java.sql.Date

        long t = 1522371600000L;
        System.out.println(LocalDate.from(new Date(t).toInstant().atZone(ZoneId.systemDefault())).atStartOfDay());
        long t2 = LocalDate.from(new Date(t).toInstant().atZone(ZoneId.systemDefault())).atStartOfDay().toEpochSecond(ZoneOffset.of("+8"));

        System.out.println(t2);
        System.out.println(LocalDate.from(new Date(t).toInstant().atZone(ZoneId.systemDefault())).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        System.out.println(LocalDate.now().atStartOfDay());
        System.out.println(LocalDate.now().atStartOfDay().minusMinutes(30 * 48));
    }


    @Test
    public void localDateTest() {
        //取当前日期
        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        //取指定日期
        LocalDate oneDay = LocalDate.of(2018, 02, 22);
        System.out.println("oneDay: " + oneDay);

        //根据字符串来指定日期
        LocalDate oneDayByStr = LocalDate.parse("2018-02-22");
        System.out.println("oneDayByStr: " + oneDayByStr);

        LocalDate oneDayByStrFormat = LocalDate.parse("2018-02-22", DateTimeFormatter.ISO_DATE);
        System.out.println("oneDayByStrFormat: " + oneDayByStrFormat);

        //根据日期加减
        LocalDate yesterday = LocalDate.now().minusDays(1L);
        System.out.println("yesterday: " + yesterday);

        LocalDate lastWeekDay = today.minusWeeks(1L);
        System.out.println("lastWeekDay: " + lastWeekDay);

        //获取日期的年月日，当月天数
        int todayYear = today.getYear();
        System.out.println("todayYear: " + todayYear);
        int monthLength = today.lengthOfMonth();
        System.out.println("monthLength: " + monthLength);

    }

    @Test
    public void localTimeTest() {
        //获取当前时间
        LocalTime timeNow = LocalTime.now();
        System.out.println("timeNow: " + timeNow);

        //获取指定时间
        LocalTime oneTime = LocalTime.of(12, 12,12);
        System.out.println("oneTime: " + oneTime);

        //解析时间 与解析日期一样
        LocalTime parseTime = LocalTime.parse("12-12-12");
        System.out.println("parseTime: " + parseTime);

    }

    @Test
    public void localDateTimeTest() {
        //获取当前日期和时间
        LocalDateTime ldtNow1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime ldtNow2 = LocalDateTime.now();
        System.out.println("ldtNow1: " + ldtNow1 + " ,ldtNow2: " + ldtNow2);

        //获取指定的日期和时间
        LocalDateTime ldt = LocalDateTime.of(2018, 3, 12, 12, 12 ,21);
        System.out.println("ldt: " + ldt);

        LocalDateTime ldt2 = LocalDate.now().atTime(12,11,10);
        System.out.println("ldt2: " + ldt2);
    }

    @Test
    public void test8() {
        //Instant This class is immutable and thread-safe.
        /**
         * Instant
         Instant表示一个精确的时间，时间数轴就是由无数个时间点组成，数轴的原点就是上面提
         到的1970-1-1 00:00:00，Instant由两部分组成，一是从原点开始到指定时间点的秒数s，
         二是距离该秒数s的纳秒数
         */
        System.out.println(Instant.ofEpochSecond(2));

        /**
         * 使用静态方法Instant.now()可以获取当前的时间点,该方法默认使用的是UTC(协调世界时——由原子钟提供)时间，
         * 可以使用equeal 和 compareTo来比较两个时间点的值。
         */
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(System.currentTimeMillis());

        //Date --> Instant
        Instant timestamp = new Date().toInstant();
        System.out.println(timestamp.toEpochMilli());

        //Instant --> Date
        Date dateFromInstant = Date.from(Instant.now());


    }

    @Test
    public void test9() {
        // date -> localdate
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDate localDate = instant.atZone(zoneId).toLocalDate();


        //localdate -> date
        Date date1 = Date.from(LocalDate.now().atStartOfDay(zoneId).toInstant());

        System.out.println(LocalDate.now().atStartOfDay());

        System.out.println(LocalDate.now().toString());

        System.out.println(LocalDate.now().atStartOfDay().toString().substring(0, 16));
    }

    @Test
    public void test10() {
        ExecutorService service = Executors.newFixedThreadPool(48);
        System.out.println(LocalDateTime.now());
        List<CompletableFuture<String>> completableFutureList = IntStream.range(0, 48)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                    try {
                        return getString();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return "...";
                    }
                }, service)).collect(Collectors.toList());

        List<String> stringList = completableFutureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(LocalDateTime.now());

    }

    public static String getString() throws InterruptedException {
        Thread.sleep(2000L);
        return "string" + Math.random();
    }

    @Test
    public void test11() {
        System.out.println("瓦工班".equalsIgnoreCase("瓦工班组"));
        long days = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.now().minusDays(2L));
        System.out.println(days);

    }

    @Test
    public void test12() {
        System.out.println(ChronoUnit.DAYS.between(LocalDate.of(2018, 5, 2), LocalDate.now()));
    }


}
