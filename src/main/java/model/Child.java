package model;

import lombok.*;

/**
 * Created by xuwei on 2017/3/8.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class Child extends Father {
    private int a;
    private int length;
    private String status;
    private Long time;
}
