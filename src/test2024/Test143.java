package test2024;

/**
 * Author: Xiyao Li
 * Date: 2024/3/3 5:39
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Test143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode hair = new ListNode(0, head);
        ListNode slow = hair;
        ListNode fast = hair;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode head2 = reverse(slow, fast);
        slow.next = null;
        ListNode p1 = head;
        ListNode p2 = head2;
        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p1.next.next;
            p2 = temp;
        }




    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = end.next;
        ListNode cur = start.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        Test143 test143 = new Test143();
        test143.reorderList(head);
    }
}
