/**
 * Created by xuwei on 2017/12/18.
 */
public class Som<T extends Comparable<T>> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

        static boolean boolValue;
        public static void main(String[] args) {
            boolValue = true; // 将这个 true 替换为 2 或者 3，再看看打印结果
            if (boolValue) System.out.println("Hello, Java!");
            if (boolValue == true) System.out.println("Hello, JVM!");
        }


}
