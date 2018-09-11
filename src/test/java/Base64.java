import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by xuw-e on 2018/9/10.
 */
public class Base64 {

    public static void main(String[] args) throws IOException {
        String source = new String(Files.readAllBytes(Paths.get("1.txt")));
        System.out.println(source);
    }
}
