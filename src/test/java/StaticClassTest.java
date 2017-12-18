import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuwei on 2017/9/30.
 */
public  class StaticClassTest {
    static String tod;
    static class StaticA {
        Map<String, String> map;

        StaticA(Map<String, String> map){
            this.map = map;
        }
    }
}
