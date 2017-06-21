package hello;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by xuwei on 2017/1/5.
 */
@RestController
public class HelloController {
    @Value("${value.string}")
    private String type;
    @RequestMapping("/aa")
    public String index() {
        return type;
    }
}
