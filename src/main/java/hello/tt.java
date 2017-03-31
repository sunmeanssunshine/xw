package hello;

import javafx.scene.Parent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuwei on 2017/2/6.
 */
@Controller
@RequestMapping("")
@EnableAutoConfiguration
public class tt {
    @ResponseBody
    @RequestMapping(value="delete", method= RequestMethod.DELETE )
    public String f(){
        return "success";
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(tt.class, args);
    }
}
