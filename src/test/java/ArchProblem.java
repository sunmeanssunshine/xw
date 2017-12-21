import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Created by xuwei on 2017/12/20.
 */
public class ArchProblem {
    public static void main(String[] args) throws IOException {
        String sourceJsonSample = "F:\\xw\\src\\main\\resources\\templates\\sample_elements_class.json";
        String sourceJsonAll = "F:\\xw\\src\\main\\resources\\templates\\elements_class.json";
        List<JsonRootBean> jsonRootBeanList = Files.lines(Paths.get(sourceJsonSample)).map(str -> jsonToBean(str)).collect(toList());
        System.out.println("json to bean end");

        List<String> selfTree = new ArrayList<>(Arrays.asList("specialty", "floor"));
        List<ArchResult> results = jsonRootBeanList.stream().collect(new MyselfCollector());

    }

    public static JsonRootBean jsonToBean(String jsonStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonRootBean jsonRootBean = new JsonRootBean();
        try {
            jsonRootBean = objectMapper.readValue(jsonStr, JsonRootBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonRootBean;
    }
}
