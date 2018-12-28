import lombok.Data;

/**
 * Created by xuw-e on 2018/12/20.
 */
@Data
public class  PersonT<T extends Number>  {
    private T name;
    private T age;

    private  int _getMoney(PersonT<?> personT) {
        return 1;
    }

    public static void main(String[] args) {


    }
}
