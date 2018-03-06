package date;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.Immutable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    }


}
