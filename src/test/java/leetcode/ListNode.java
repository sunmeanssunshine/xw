package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by xuw-e on 2018/9/27.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value1 = l1.val;
        int value2 = l2.val;
        int sum = value1 + value2;
        int high = sum / 10;
        ListNode result = new ListNode(sum % 10);
        ListNode cur = result;
        l1 = l1.next;
        l2 = l2.next;
        for (;l1 != null || l2 != null;) {
            if (l1 == null) {
                value1 = 0;
            } else {
                value1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                value2 = 0;
            } else {
                value2 = l2.val;
                l2 = l2.next;
            }
            sum = value1 + value2 + high;
            high = sum / 10;
            if (sum == 0 && high == 0 && l1 == null && l2 == null) {
                break;
            }
            ListNode next = new ListNode(sum % 10);
            cur.next = next;
            cur = next;
        }
        if (high != 0) {
            ListNode next = new ListNode(high);
            cur.next = next;
        }
        return result;
    }


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
