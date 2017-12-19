import org.junit.Test;

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
}
