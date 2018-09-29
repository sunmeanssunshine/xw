package study;

import java.util.EnumSet;

/**
 * Created by xuwei on 2017/6/6.
 */
public class EnumTest {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        Day[] days = Day.values();
        for (Day day : days) {
            System.out.println(day);
        }


        System.out.println("------------------");

        EnumSet<Day> enumSet = EnumSet.range(Day.MONDAY, Day.WEDNESDAY);
        for (Day day : enumSet) {
            System.out.println(day);
        }

    }
}
