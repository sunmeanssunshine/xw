import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by xuwei on 2017/12/20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonRootBean {
    private String specialty;
    private String floor;
    private String categoryId;
    private String categoryName;
    private String family;
    private String familyType;
    private List<Integer> boundingBox;
    private List<Elements> elements;
    private int elementsCount;
}
