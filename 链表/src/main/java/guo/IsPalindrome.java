package guo;

public class IsPalindrome {
    static ListNode front;

    public static void main(String[] args) {
        ListNode list = utils.createList();
        System.out.println(isPalindrome(list));
    }

    public static boolean isPalindrome(ListNode head) {
        front = head;
        return recursion(head);
    }

    public static boolean recursion(ListNode node) {
        if(node != null){
            if(!recursion(node.next)){
                return false;
            }
            if(front.val != node.val){
                return false;
            }
            front = front.next;
        }
        return true;
    }
}
