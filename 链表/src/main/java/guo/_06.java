package guo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _06 {
    public static void main(String[] args) {
        ListNode listNode = utils.createList();
        _06 v = new _06();
        int[] result = v.reversePrint(listNode);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+";");
        }
    }

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> integers = new ArrayList<>();
        while (head!=null)
        {
            integers.add(head.val);
            head=head.next;
        }
        Collections.reverse(integers);
        int[] result=new int[integers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=integers.get(i);
        }
        return result;
    }
}

