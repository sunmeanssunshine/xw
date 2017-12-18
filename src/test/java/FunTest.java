import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuwei on 2017/11/16.
 */
public class FunTest {
    public static void main(String[] args) {
        Map<String,String> memberMap = new HashMap<>();
        FunTest funTest = new FunTest();
        for (int i=0; i<3; i++) {
            String name = funTest.get(memberMap, "1");
        }
    }

    private String get(Map<String,String> memberMap, String id) {
        String name= "";
//        if (memberMap == null) {
//            memberMap = new HashMap<String, String>();
//        }

        if (memberMap.isEmpty()) {
            List<String> strings = new ArrayList<>();
            strings.add("1");
            strings.add("2");
            strings.add("3");
            memberMap.put("1", strings.get(0));
            memberMap.put("2", strings.get(1));
            memberMap.put("3", strings.get(2));
        }

        if (memberMap.containsKey(id)) {
            name = memberMap.get(id);
        }

        return name;
    }
}
