package study;

/**
 * Created by xuwei on 2017/2/27.
 */
public class TT <T>{
    private String str;
    private T t;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        CC cc = new CC();
        TT<CC> cctt = new TT<>();
        cctt.setT(cc);
        cctt.getT().setString("dd");
        System.out.println(cctt.getT().getString());

    }
}
