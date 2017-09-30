package annotation;

/**
 * Created by xuwei on 2017/9/29.
 */
public class B {
    @NeedTest()
    public void del(int id) {
        System.out.println("del: " + id);
    }

    @NeedTest(value = false)
    public void delOther(int id) {
        System.out.println("delOther: " + id);
    }
}
