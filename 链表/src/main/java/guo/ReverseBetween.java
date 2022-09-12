package guo;

import java.util.Stack;

public class ReverseBetween {
    public static void main(String[] args) {
        ListNode list = utils.createList();
        ListNode res = reverseBetween(list, 1, 2);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode vir_head =new ListNode(-1);
        vir_head.next = head;
        ListNode curr =vir_head;
        for(int i =0;i<left;i++){
            curr=curr.next;
        }
        Stack<Integer> stack =new Stack();
        for(int i =left;i<=right;i++){
            stack.push(curr.val);
            curr=curr.next;
        }
        ListNode res =new ListNode(-1);
        ListNode temp =res;
        for(int i =1;i<left;i++){
            res.next=new ListNode(head.val);
            head=head.next;
            res=res.next;
        }
        for(int i =left;i<=right;i++){
            res.next=new ListNode(stack.pop());
            res=res.next;
        }
        while(curr!=null){
            res.next=new ListNode(curr.val);
            curr=curr.next;
            res=res.next;
        }
        return temp.next;
    }
}
