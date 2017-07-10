package study.streamDemo;

import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by xuwei on 2017/6/30.
 */
public class Testttt {
    public static void main(String[] args) {
        String s = "following_version_id\n" +
                "ed5ab1ee9c6846dea627669f7d5a730d\n" +
                "0328a1c20c804a9caaeebf1ff920509b\n" +
                "73ed3be90e2c42e9944b0711767d692c\n" +
                "0328a1c20c804a9caaeebf1ff920509b\n" +
                "070e0289707b4866a41ec099c73f48b7\n" +
                "33875485e157444792db61217b34e874\n" +
                "070e0289707b4866a41ec099c73f48b7\n" +
                "26711304f4f844bda222b6e6b5b9dab5\n" +
                "c2fe6a5cb3e7443590f99b0ada5642e5\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "70c804e6a2fa4441a6f2e28316a5006c\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "c2fe6a5cb3e7443590f99b0ada5642e5\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "26711304f4f844bda222b6e6b5b9dab5\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "5b9d9febe3ed42f9ad008788481e7969\n" +
                "1794226de71e4856ac696b5a56ea3cf9\n" +
                "1794226de71e4856ac696b5a56ea3cf9\n" +
                "3861ccae466148a3b8f519249c660044\n" +
                "3861ccae466148a3b8f519249c660044\n" +
                "d1b44789e12c4ff6b82dd599b4d49d0f\n" +
                "d1b44789e12c4ff6b82dd599b4d49d0f\n" +
                "7339c0bff7494c91b436a2ce2bf8be8a\n" +
                "7339c0bff7494c91b436a2ce2bf8be8a";
        String result = Stream.of(s.split("\n")).distinct().collect(Collectors.joining("','"));
        System.out.println(result);
        //ConcurrentMap

        String ss = "1126328225514272.346523";
        System.out.println(ss.split("\\.")[0]);

    }
}
