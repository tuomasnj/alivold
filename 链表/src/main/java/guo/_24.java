package guo;
import java.util.Scanner;

public class _24 {
    public static void main(String[] args) {
        ListNode listNode = utils.createList();
        _24 v = new _24();
        ListNode resultNode=v.reverseList(listNode);
        while (resultNode!=null)
        {
            System.out.print(resultNode.val+";");
            resultNode=resultNode.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
           ListNode next=cur.next;
           cur.next=pre;
           pre=cur;
           cur=next;
        }
        return pre;
    }
}
