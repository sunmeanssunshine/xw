import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by xuwei on 2017/12/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elements {
    private String fileId;
    private List<String> elementIds;
}
