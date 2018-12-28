package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by xuw-e on 2018/11/2.
 */
public class Dynamic {
    public int helper(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(Arrays.copyOfRange(nums, 0, length-1)), helper(Arrays.copyOfRange(nums, 0, length-2)) + nums[length-1]);
    }

    public int helper(int[] nums, Map<Integer, Integer> map) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        if (map.containsKey(length-1)) return map.get(length-1);
        if (map.containsKey(length-2)) return map.get(length-2);
        int result = Math.max(helper(Arrays.copyOfRange(nums, 0, length-1), map),
                helper(Arrays.copyOfRange(nums, 0, length-2), map) + nums[length-1]);
        map.put(length, result);
        return result;
    }

    public String addBinary(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();
        int len = len_a > len_b ? len_a : len_b;
        int flag = 0;
        String sum = "";
        int int_a, int_b = 0;
        for (int i=0; i<len; i++) {
            if (len_a-i > 0) {
                int_a = Character.getNumericValue(a.charAt(len_a-1-i));
            } else {
                int_a = 0;
            }
            if (len_b-i > 0) {
                int_b = Character.getNumericValue(b.charAt(len_b-1-i));
            } else {
                int_b = 0;
            }
            sum += String.valueOf((flag+int_a+int_b)%2);
            flag = (flag+int_a+int_b)/2;
        }
        if (flag == 1) {
            sum += "1";
        }
        return sum;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<List<Integer>> resultStack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.peek() != null) {
            List<Integer> values = new LinkedList<>();
            Queue<TreeNode> leafs = new LinkedList<>();
            while (queue.peek() != null) {
                TreeNode parent = queue.poll();
                values.add(parent.val);
                if (parent.left != null) leafs.add(parent.left);
                if (parent.right != null) leafs.add(parent.right);
            }
            for (TreeNode leaf : leafs) {
                queue.add(leaf);
            }
            resultStack.push(values);
        }
        List<List<Integer>> result = new LinkedList<>();
        while (!resultStack.isEmpty()) {
            result.add(resultStack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 1};
        Dynamic dynamic = new Dynamic();
//        int result = dynamic.helper(nums);
//        System.out.println(result);

        dynamic.addBinary("11", "11");
    }
}
