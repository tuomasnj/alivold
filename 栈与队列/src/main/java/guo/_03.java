package guo;
import java.util.Deque;
import java.util.LinkedList;

public class _03 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (stack1.isEmpty() == false) {
                int num = stack1.pop();
                stack2.push(num);
            }
        }
        if(stack2.isEmpty())
        {
            return -1;
        }
        return stack2.pop();
    }
}