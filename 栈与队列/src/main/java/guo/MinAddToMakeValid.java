package guo;

import java.util.ArrayDeque;

public class MinAddToMakeValid {
    public static void main(String[] args) {
        String s = "(((";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        int count = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }
        return count + stack.size();
    }
}
