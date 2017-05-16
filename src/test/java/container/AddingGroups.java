package container;

import model.Child;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuwei on 2017/4/1.
 */
public class AddingGroups {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.set(0, 10);
        list.forEach(e->{
                    if (e > 2){
                        System.out.println(e*2);
                    }
                });
        //list.add(5);//error unSupportedOperation

    }
}
