import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.hashids.Hashids;

import java.util.Arrays;

/**
 * Created by xuw-e on 2018/7/11.
 */
public class HashCodeTest {


    public static void main(String[] args) {
        String s = "ddaeafaefaefafaaaaaaaaaaaaaaaaaaaaaaadsaeafefaf";
        System.out.println(s.hashCode());
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println("-----------------------------------------");

        Hashids hashids = new Hashids(s);
        String hash = hashids.encode(12345L);
        System.out.println(hash);
        String hash1 = hashids.encode(1,2,3);
        System.out.println(hash1);
        Arrays.stream(hashids.decode(hash)).forEach(e-> System.out.println(e));

        System.out.println("-----------------------------------------");
        String s_500 = RandomStringUtils.randomAlphanumeric(500);
        System.out.println(s_500);
        System.out.println(s_500.length());
        Hashids hashid_500 = new Hashids(s);
        String hash2 = hashid_500.encode(12345L);
        System.out.println(hash2);


        String hash3 = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";

        String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
        System.out.println(md5Hex);
        System.out.println("-----------------------------------------");

        String bigString = RandomStringUtils.randomAlphanumeric(500);
        System.out.println(bigString);
        String bigStringMd5 = DigestUtils.md5Hex(bigString);
        System.out.println(bigStringMd5);

    }
}
