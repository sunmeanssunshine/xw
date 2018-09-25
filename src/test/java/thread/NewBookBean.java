package thread;

import lombok.Data;

/**
 * Created by xuw-e on 2018/9/20.
 */
@Data
public class NewBookBean {
    private String name;
    private Integer count;

    public NewBookBean(String name, Integer count) {
        this.name = name;
        this.count = count;
    }
}
