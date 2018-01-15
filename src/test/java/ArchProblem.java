import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.json.JSONObject;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
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


    }

    @Test
    public void test1() throws IOException {
        /**
         * 样例1
         * 自定义筛选树1：["specialty", "floor"]， 结果1：
         */
        String sourceJsonSample = "F:\\xw\\src\\main\\resources\\templates\\sample_elements_class.json";
        String sourceJsonAll = "F:\\xw\\src\\main\\resources\\templates\\elements_class.json";
        List<JsonRootBean> jsonRootBeanList = Files.lines(Paths.get(sourceJsonSample)).map(str -> jsonToBean(str)).collect(toList());
        System.out.println("json to bean end");

        List<ArchResult> archResults = new ArrayList<>();
        Map<String, Map<String, List<JsonRootBean>>> tmpResult = jsonRootBeanList.stream().collect(groupingBy(JsonRootBean::getSpecialty, groupingBy(JsonRootBean::getFloor)));
        for (String key1 : tmpResult.keySet()) {
            ArchResult archResult = new ArchResult();
            archResult.setType("specialty");
            archResult.setName(key1);
            List<ArchResult> subItems = new ArrayList<>();
            archResult.setItems(subItems);
            for (String key2 : tmpResult.get(key1).keySet()) {
                ArchResult subArchResult = new ArchResult();
                subArchResult.setType("floor");
                subArchResult.setName(key2);
                subItems.add(subArchResult);
            }
            archResults.add(archResult);
        }
        System.out.println(archResults);
    }

    @Test
    public void test2() throws IOException {
        /**
         * 样例2
         * 自定义筛选树2：[ "floor", "category", "specialty"]， 结果2：
         */
        String sourceJsonSample = "F:\\xw\\src\\main\\resources\\templates\\sample_elements_class.json";
        String sourceJsonAll = "F:\\xw\\src\\main\\resources\\templates\\elements_class.json";
        List<JsonRootBean> jsonRootBeanList = Files.lines(Paths.get(sourceJsonSample)).map(str -> jsonToBean(str)).collect(toList());

        System.out.println("json to bean end");
        Long timeStart = System.nanoTime();
        List<ArchResult> archResults = getArchResults(jsonRootBeanList);
        System.out.println(System.nanoTime() - timeStart);

        List<JsonRootBean> jsonRootBeanList1 = Files.lines(Paths.get(sourceJsonAll)).map(str -> jsonToBean(str)).collect(toList());
        Long timeStart1 = System.nanoTime();
        List<ArchResult> archResults1 = getArchResultsParallel(jsonRootBeanList);
        System.out.println(System.nanoTime() - timeStart1);
    }

    public List<ArchResult> getArchResults(List<JsonRootBean> jsonRootBeanList) {
        List<ArchResult> archResults = new ArrayList<>();
        Map<String, Map<String, Map<String, List<JsonRootBean>>>> tmpResult = jsonRootBeanList.stream().collect(groupingBy(JsonRootBean::getFloor, groupingBy(JsonRootBean::getCategoryName, groupingBy(JsonRootBean::getSpecialty))));
        getResult(archResults, tmpResult);
        return archResults;
    }

    public List<ArchResult> getArchResultsParallel(List<JsonRootBean> jsonRootBeanList) {
        List<ArchResult> archResults = new ArrayList<>();
        Map<String, Map<String, Map<String, List<JsonRootBean>>>> tmpResult = jsonRootBeanList.stream().parallel().collect(groupingBy(JsonRootBean::getFloor, groupingBy(JsonRootBean::getCategoryName, groupingBy(JsonRootBean::getSpecialty))));
        getResult(archResults, tmpResult);
        return archResults;
    }

    public void getResult(List<ArchResult> archResults, Map<String, Map<String, Map<String, List<JsonRootBean>>>> tmpResult) {
        for (String key1 : tmpResult.keySet()) {
            ArchResult archResult = new ArchResult();
            archResult.setType("floor");
            archResult.setName(key1);
            List<ArchResult> subItems = new ArrayList<>();
            archResult.setItems(subItems);
            Map<String, Map<String, List<JsonRootBean>>> level2Map = tmpResult.get(key1);
            for (String key2 : level2Map.keySet()) {
                ArchResult sub2ArchResult = new ArchResult();
                sub2ArchResult.setType("category");
                sub2ArchResult.setName(key2);
                List<ArchResult> sub2Items = new ArrayList<>();
                sub2ArchResult.setItems(sub2Items);
                subItems.add(sub2ArchResult);
                Map<String, List<JsonRootBean>> level3Map = level2Map.get(key2);
                for (String key3 : level3Map.keySet()) {
                    ArchResult sub3ArchResult = new ArchResult();
                    sub3ArchResult.setType("specialty");
                    sub3ArchResult.setName(key3);
                    sub2Items.add(sub3ArchResult);
                }

            }
            archResults.add(archResult);
        }
    }

    @Test
    public void test3() throws IOException {
        String sourceJsonSample = "F:\\xw\\src\\main\\resources\\templates\\sample_elements_class.json";
        String sourceJsonAll = "F:\\xw\\src\\main\\resources\\templates\\elements_class.json";
        List<JsonRootBean> jsonRootBeanList = Files.lines(Paths.get(sourceJsonSample)).map(str -> jsonToBean(str)).collect(toList());
        System.out.println("json to bean end");


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
