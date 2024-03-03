package prev;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static class ListNode {
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

    public static ListNode doubleIt(ListNode head) {
        ListNode tempHead = head;
        ListNode p = head;

        StringBuilder sb = new StringBuilder();
        while (p != null) {
            sb.append(String.valueOf(p.val));
            p = p.next;
        }
        // String num1 = sb.toString();


        String num1 = sb.reverse().toString();
        int addDigit = 0;
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < num1.length(); i++) {
            int doubleNum = (num1.charAt(i) - '0') * 2;
            sb2.append(String.valueOf( doubleNum %10 + addDigit));

            addDigit = doubleNum /10;
        }
        if (addDigit == 1) {
            sb2.append(String.valueOf(addDigit));
        }

        String num2 = sb2.reverse().toString();
        p = head;
        for (int i = 0; i < num2.length(); i++) {
            if (i == 0) {
                head.val = num2.charAt(i) - '0';
            } else {
                ListNode node = new ListNode();
                p.next = node;
                node.val = num2.charAt(i) - '0';
                p=node;
                System.out.println(node.val);
            }
        }
        return tempHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        ListNode temp = new ListNode();
        head.next = temp;
        temp.val = 8;
        ListNode temp2 = new ListNode();
        temp.next = temp2;
        temp2.val = 9;
        ListNode listNode = doubleIt(head);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}