package study;

import model.Father;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.*;

/**
 * Created by xuwei on 2017/3/22.
 */
public class OptionalTest {
    public static void main(String[] args) {
        Father father = new Father();
        father.setFa("a");
        Optional<Father> fatherOptional = Optional.ofNullable(father);
        fatherOptional.ifPresent(e->System.out.print(e.getFa()));
        fatherOptional.orElse(father);

    }
}
