public class _18 {
    public static void main(String[] args) {
        ListNode list = utils.createList();
        deleteNode(list,10);
        while (list!=null){
            System.out.println(list.val);
            list=list.next;
        }
    }
    public static ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            return head.next;
        }
        ListNode begin=head;
        ListNode slow=head,fast=head.next;
        while (fast.val!=val){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=fast.next;
        return begin;
    }
}
