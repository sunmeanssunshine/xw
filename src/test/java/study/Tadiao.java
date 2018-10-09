package study;

/**
 * Created by xuw-e on 2018/10/9.
 */
public enum  Tadiao {

    U1(132), U2(262),U3(480),U4(680),U5(990);

    private Integer useCount;
    Tadiao(Integer useCount) {
        this.useCount = useCount;
    }

    public static void main(String[] args) {
        int a = 122;
        Tadiao tadiao = Tadiao.U1;

    }
}
