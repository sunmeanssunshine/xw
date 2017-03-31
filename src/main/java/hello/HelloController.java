package hello;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by xuwei on 2017/1/5.
 */
@RestController
public class HelloController {
    @RequestMapping("/aa")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
