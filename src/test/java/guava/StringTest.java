package guava;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by xuwei on 2018/2/27.
 */
public class StringTest {

    @Test
    public void Joiner() {
        Joiner joiner = Joiner.on(", ").skipNulls();
        System.out.println(joiner.join("xx", "yy", null, "zzz dd"));
        /**
         * xx, yy, zzz dd
         */

        System.out.println(Joiner.on(",").join(Arrays.asList(1,2,3,4)));
        /**
         * 1,2,3,4
         */
    }


    @Test
    public void Splitter() {
        Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux")
                .forEach(System.out::println);
        /**
         * foo
           bar
           qux
         */

        Splitter.on(',').limit(3).split("a,b,c,d").forEach(System.out::println);
        /**
         * a
           b
           c,d
         */
    }


    @Test
    public void CaseFormat() {
        String str = CaseFormat
                .UPPER_UNDERSCORE
                .to(CaseFormat.LOWER_CAMEL, "COnSTANT_NAME"); // returns "constantName"

        System.out.println(str);
        /**
         * constantName
         */
    }


}
