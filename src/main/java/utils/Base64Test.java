package utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by xuwei on 2017/2/17.
 */
public class Base64Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String bimFaceCode = "aDlPf13UtiGs7yuHCd8eHSLHbHJTU8Sd:voL9cWmkdu962V1tN0FE8aVsAD76HDGy";
        String asB64 = Base64.getEncoder().encodeToString(bimFaceCode.getBytes("utf-8"));
        System.out.println(asB64);

        byte[] asBytes = Base64.getDecoder().decode(asB64);
        System.out.println(new String(asBytes, "utf-8")); // 输出为: some string
    }
}
