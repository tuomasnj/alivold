package guo;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = utils.createList();
        ListNode list2 = utils.createList();
        ListNode listNode = mergeTwoLists(list1, list2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                res.next = list1;
                list1 = list1.next;
            }else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        res.next = list1 == null? list2 : list1;
        return head.next;
    }
}
