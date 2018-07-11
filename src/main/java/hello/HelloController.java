package hello;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

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

    @GetMapping(value = "/download")
    public void downloadApk(HttpServletResponse response, @RequestParam(value = "name") String name) {
        try (InputStream inputStream = new FileInputStream(new File("/home/res/" + name))) {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8"));
            IOUtils.copy(inputStream, response.getOutputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
