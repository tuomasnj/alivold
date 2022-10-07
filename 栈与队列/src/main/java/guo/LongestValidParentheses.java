package guo;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s){
        int ans = 0;
        Deque<Character> deque =new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(j) == '('){
                    deque.push('(');
                }else{
                    if(deque.isEmpty()){
                        break;
                    }else {
                        deque.pop();
                    }
                }
                if(deque.isEmpty()){
                    ans = Math.max(ans, j - i + 1);
                }
            }
            deque.clear();
        }
        return ans;
    }
}
