package aa;

import org.apache.catalina.User;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuwei on 2017/1/7.
 */
@RestController
public class Hello1Controller {
    @RequestMapping("/aa")
    public String index(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){

        }
        return "aa";
    }



    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("MMM d, YYYY");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }
}
