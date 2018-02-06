package study.streamDemo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * Created by xuwei on 2018/2/5.
 */
public class FlatmpTest {
    public static void main(String[] args) {

    }
    @Data
    class entity{
        private String id;
        private String a;
        private String b;
    }

    public List<entity> findByA(String a) {
        return Lists.newArrayList();
    }
}
