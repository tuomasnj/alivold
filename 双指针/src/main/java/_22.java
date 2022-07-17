public class _22 {
    public static void main(String[] args) {
        ListNode list = utils.createList();
        ListNode kthFromEnd = getKthFromEnd(list, 2);
        while (kthFromEnd!=null){
            System.out.println(kthFromEnd.val);
            kthFromEnd=kthFromEnd.next;
        }
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left=head;
        ListNode right=head;
        while (k-->0){
            right=right.next;
        }
        while (right!=null){
            left=left.next;
            right=right.next;
        }
        return left;
    }
}
