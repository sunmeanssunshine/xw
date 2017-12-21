import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xuwei on 2017/12/19.
 */
public class RegularExpression {

    @Test
    public void test1() {
        String text    =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";
        String pattern = ".*http://.*";
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("matches = " + matches);
    }

    @Test
    public void test2() {
        String text = "b";
        String pattern = "[abc]";
        System.out.println("matches = " + Pattern.matches(pattern, text));
    }

    @Test
    public void test3() {
        System.out.println(Pattern.matches("\\d+","2223"));
        System.out.println(Pattern.matches("\\d+","2223aa"));
        System.out.println(Pattern.matches("\\d+","22bb23"));

        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("aaa2223bb");
        System.out.println(m.find());//匹配2223
        System.out.println(m.start());//返回3
        System.out.println(m.end());//返回7,返回的是2223后的索引号
        System.out.println(m.group());//返回2223
    }
}
