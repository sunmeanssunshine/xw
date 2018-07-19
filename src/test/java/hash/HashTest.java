package hash;

import org.apache.commons.codec.digest.DigestUtils;

public class HashTest {


    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("helloworld"));
        byte[] bytes = DigestUtils.sha256("helloworld");
        for (int i=0; i<bytes.length; i++) {
            System.out.print(bytes[i]);
        }
    }
}
