package guo;

import java.util.Scanner;

public class utils {
    public static ListNode createList(){
        int count = 0;
        ListNode preNode = new ListNode(0);
        ListNode start = preNode;
        ListNode node = null;
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        while (count < length) {
            int num = sc.nextInt();
            node = new ListNode(num);
            preNode.next = node;
            preNode = preNode.next;
            count++;
        }
        return start.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next=null;
        this.random=null;
    }
}
