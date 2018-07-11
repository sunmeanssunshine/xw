import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xuwei on 2017/12/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchResult {
    private String type;
    private String name;
    private List<ArchResult> items;
    private Integer value;

    public static void main(String[] args) {
        List<ArchResult> archResults = new ArrayList<>();
        ArchResult archResult = new ArchResult("1", null, new ArrayList<>(), null);
        archResults.add(archResult);
        ArchResult archResult1 = new ArchResult("2", "1", new ArrayList<>(),null);
        archResults.add(archResult1);

        ArchResult archResult2 = new ArchResult("3", null, new ArrayList<>(), 2);
        archResults.add(archResult2);

        double a = archResults.stream().filter(e -> e.getValue() != null).collect(Collectors.averagingDouble(ArchResult::getValue));
        System.out.println(a);
    }
}
