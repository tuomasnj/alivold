package guo;

import java.util.HashMap;
import java.util.Map;

public class _35 {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public static void main(String[] args) {
        _35 object = new _35();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.next = null;
        node2.random = node1;
        object.copyRandomList(node1);
    }

    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        int number = 0;
        Node cur = head;
        HashMap<Integer, Integer> map1 = new HashMap();
        HashMap<Integer, Integer> map2 = new HashMap();
        while (cur != null) {
            if (cur.next != null) {
                map1.put(number, cur.next.val);
            } else {
                map1.put(number, null);
            }
            cur = cur.next;
            number++;
        }
        Node newList = new Node(0);
        newList.next = new Node(head.val);
        Node start = newList.next;
        int length = map1.size();
        int index = 0;
        while (index < length - 1) {
            newList.next.next = new Node(map1.get(index));
            index++;
            newList = newList.next;
        }
        newList.next.next = null;

        cur = head;
        Node mov;
        for (int i = 0; i < number; i++) {
            mov = head;
            for (int j = 0; j <= number; j++) {
                if (cur.random == mov) {
                    map2.put(i, j);
                    break;
                }
                mov = mov.next;
            }
            cur = cur.next;
        }
        cur = start;
        for (int i = 0; i < number; i++) {
            if (map2.get(i) == null) {
                index = number;
            } else {
                index = map2.get(i);
            }
            mov=start;
            for (int j = 0; j <= number; j++) {
                if (index == j) {
                    cur.random = mov;
                    break;
                }
                mov = mov.next;
            }
            cur = cur.next;
        }
        return start;
    }
}

