public class _25 {
    public static void main(String[] args) {
        ListNode list1 = utils.createList();
        ListNode list2 = utils.createList();
        ListNode listNode = mergeTwoLists(list1, list2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return head.next;
    }
}
