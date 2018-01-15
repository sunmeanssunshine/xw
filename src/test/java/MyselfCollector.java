import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * Created by xuwei on 2017/12/20.
 */
public class MyselfCollector implements Collector<JsonRootBean, List<ArchResult>, List<ArchResult>> {

    List<String> selfTree = new ArrayList<>(Arrays.asList("specialty", "floor"));



    /**
     * supplier方法会返回一个在调用时创建累加器的函数
     * @return
     */
    @Override
    public Supplier<List<ArchResult>> supplier() {
        return () -> new ArrayList<>();
    }

    /**
     * 收集器中最重要的方法是accumulator，因为它定义了如何收集流中元素的逻辑
     * @return
     */
    @Override
    public BiConsumer<List<ArchResult>, JsonRootBean> accumulator() {
        return (List<ArchResult> result, JsonRootBean jsonRootBean) -> {

            if (CollectionUtils.isEmpty(selfTree)) {
                //什么也不干
            } else {
                if (CollectionUtils.isEmpty(result)) {

                } else {
                    //判断是否包含
                }
                ArchResult archResult = new ArchResult();

                selfTree.forEach(e->{

                });

                result.add(archResult);
            }

        };
    }

    /**
     * 让收集器并行工作（如果可能）
     * @return
     */
    @Override
    public BinaryOperator<List<ArchResult>> combiner() {
        return null;
    }

    /**
     * accumulator正好就是收集器的结果，用不着
     进一步转换，那么finisher方法就返回identity函数
     * @return
     */
    @Override
    public Function<List<ArchResult>, List<ArchResult>> finisher() {
        return Function.identity();
    }

    /**
     * 统计结果
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }

    public static ArchResult getArchResultBySelfItem(String selfItem, JsonRootBean jsonRootBean) {
        ArchResult archResult = new ArchResult();
        if ("specialty".equals(selfItem)) {
            archResult.setType(selfItem);
            archResult.setName(jsonRootBean.getSpecialty());
            archResult.setItems(new ArrayList<>());
        } else if ("floor".equals(selfItem)) {
            archResult.setType(selfItem);
            archResult.setName(jsonRootBean.getFloor());
            archResult.setItems(new ArrayList<>());
        }
        return archResult;
    }
}
