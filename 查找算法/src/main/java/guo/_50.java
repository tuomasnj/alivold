package guo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _50 {
    public static void main(String[] args) {
        String str= "abaccdeff";
        char c = firstUniqChar(str);
        System.out.println(c);
    }
    public static char firstUniqChar(String s) {
        if(s.length()==0){
            return ' ';
        }
        Queue<Character> queue=new LinkedList<>();
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            queue.add(c);
        }
        while (!queue.isEmpty()){
            Character result= queue.poll();
            if(map.get(result)==1){
                return result;
            }
        }
        return ' ';
    }
}
