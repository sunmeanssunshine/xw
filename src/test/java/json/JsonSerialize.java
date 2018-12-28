package json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuw-e on 2018/10/29.
 */
public class JsonSerialize {

    public static <T> T json2Object(String json, Class<T> tClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        try {
            return objectMapper.readValue(json, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> String objectToJson(T t) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        try {
            return mapper.writeValueAsString(t);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        JsonSerialize jsonSerialize = new JsonSerialize();
        My my = jsonSerialize.new My();
        my.setName("hh");
        System.out.println(objectToJson(my));
    }

    @Data
    class My {
        private String name;
        private List<String> infos = new ArrayList<>();
    }
}
