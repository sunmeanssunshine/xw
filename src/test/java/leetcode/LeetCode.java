package leetcode;

import org.junit.Test;

/**
 * Created by xuw-e on 2018/9/27.
 */
public class LeetCode {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i=0; i<nums.length; i ++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    @Test
    public void test1() {

    }
}
