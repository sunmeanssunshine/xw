package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuw-e on 2018/10/18.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        cur.next = null;
        ListNode temp;
        while (next != null) {
            temp = next;
            next = next.next;
            temp.next = cur;
            cur = temp;
        }
        return cur;
    }

    /**
     * 链表是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 链表是否有环
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (nodes.contains(p)) {
                return true;
            }
            nodes.add(p);
            p = p.next;
        }
        return false;
    }

    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (nodes.contains(p)) {
                return p;
            }
            nodes.add(p);
            p = p.next;
        }
        return null;
    }
}
