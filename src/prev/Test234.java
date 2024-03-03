package prev;

public class Test234 {

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode p = preHead;
        ListNode q = preHead;
        while(q.next != null){
            if(q.next.next == null){
                return false;
            }
            p = p.next;
            q = q.next.next;
        }
        q = p.next;
        p = head;

        ListNode p2 = reverseList(q);
        while(p2 != null){
            if(p.val != p2.val){
                return false;
            }
            p = p.next;
            p2 = p2.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(1);

        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
