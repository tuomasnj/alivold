package guo;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {
    public static void main(String[] args) {
        String[] strs = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(strs));
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                Integer a = deque.pop();
                Integer b = deque.pop();
                deque.push(a + b);
            }else if(s.equals("*")){
                Integer a = deque.pop();
                Integer b = deque.pop();
                deque.push(a * b);
            }else if(s.equals("-")){
                Integer a = deque.pop();
                Integer b = deque.pop();
                deque.push(b - a);
            }else if(s.equals("/")){
                Integer a = deque.pop();
                Integer b = deque.pop();
                deque.push(b / a);
            }else {
                deque.push(Integer.parseInt(s));
            }
        }
        return deque.peek();
    }
}
