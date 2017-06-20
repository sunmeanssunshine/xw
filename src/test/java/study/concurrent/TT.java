package study.concurrent;

import com.google.common.collect.Maps;

import javax.sound.midi.Soundbank;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by xuwei on 2017/6/19.
 */
public class TT {
    public static void main(String[] args) {

        for (int i=0; i<1; i++){
            System.out.println("i " + i);
            IntStream.range(0, 5).forEach(j->{
                System.out.println("j " + j);
                if (j==2){
                    return;
                }
                System.out.println("165465");
            });
        }
        System.out.println("ddd");

        Map<String, String> map = Maps.newHashMap();
        map.put("1","1");
        map.put("2","2");
        System.out.println(map.get("3"));
    }
}
