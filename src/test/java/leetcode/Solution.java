package leetcode;

import java.util.*;

/**
 * Created by xuw-e on 2018/10/31.
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasTargetSum(root, sum, root.val);
    }

    public boolean hasTargetSum(TreeNode root, int target, int total) {
        if (target == total && root.left == null && root.right == null) {
            return true;
        }
        boolean result = false;
        if (root.left != null) {
            result = hasTargetSum(root.left, target, total + root.left.val);
        }

        if (root.right != null) {
            result = hasTargetSum(root.right, target, total + root.right.val);
        }
        return result;
    }

    public int myAtoi(String str) {
        str = str.trim();
        int length = str.length();
        int flag = 1;
        for (int i = 0; i < length; i++) {
            Set<String> set = new HashSet<>();
        }
        int[] a = new int[5];
        int c = a.length;

//        String[] split = "s".split(" ");
//        return split[split.length-1].length();
        return 0;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        return new ArrayList<>();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        if (headA == null || headB == null) return null;
        ListNode pa = headA;
        do {
            set.add(pa);
            pa = pa.next;
        } while (pa != null);
        ListNode pb = headB;
        do {
            if (set.contains(pb)) {
                return pb;
            }
            pb = pb.next;
        } while (pb != null);
        return null;
    }

    public void rotate(int[] nums, int k) {

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }

    public static void main(String[] args) {
        int a = 2;
        switch (a) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");break;
            default:
                System.out.println("4");
        }
    }
}
