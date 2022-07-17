package guo;

import java.util.Deque;
import java.util.LinkedList;

public class _30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
class MinStack {
    Deque<Integer> deque1;
    Deque<Integer> deque2;
    public MinStack() {
        deque1=new LinkedList<>();
        deque2=new LinkedList<>();
    }

    public void push(int x) {
        deque1.push(x);
        if(deque2.isEmpty() || deque2.peek()>=x){
            deque2.push(x);
        }
    }

    public void pop() {
        if(deque1.pop().equals(deque2.peek()))
            deque2.pop();
    }

    public int top() {
        return deque1.peek();
    }

    public int min() {
        return deque2.peek();
    }
}