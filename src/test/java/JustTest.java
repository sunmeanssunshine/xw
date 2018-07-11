import org.junit.Test;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuw-e on 2018/6/1.
 */
public class JustTest {

    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("2", "3");
        map.keySet().stream().forEach(Key -> System.out.println(map.get(Key)));
    }
}
