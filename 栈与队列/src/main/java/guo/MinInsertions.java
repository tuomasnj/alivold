package guo;

import java.util.ArrayDeque;

public class MinInsertions {
    public static void main(String[] args) {
        String s = ")())(";
        System.out.println(minInsertions(s));
    }
    public static int minInsertions(String s){
        int n = s.length();
        int ans = 0;
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                deque.push('(');
            }else {
                if(deque.isEmpty()){
                    if(i + 1 < n){
                        if(s.charAt(i + 1) == ')'){
                            i ++;
                        }else {
                            ans ++;
                        }
                    }else {
                        ans ++;
                    }
                    ans ++;
                }else {
                    deque.pop();
                    if(i + 1 < n){
                        if(s.charAt(i + 1) == ')'){
                            i++;
                        }else {
                            ans ++;
                        }
                    }else {
                        ans ++;
                    }
                }
            }
        }
        return ans + deque.size() * 2;
    }
}
