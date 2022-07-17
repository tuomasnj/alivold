import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 双端队列实现滑动窗口
 * 时间复杂度依然为O(n^2)
 */
public class _48 {
    public static void main(String[] args) {
        String s="asadsfegsd";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            if (!deque.contains(s.charAt(i))) {
                deque.addLast(s.charAt(i));
            }else {
                max = Math.max(max, deque.size());
                while(deque.peekFirst()!=s.charAt(i)) {
                    deque.removeFirst();
                }
                deque.removeFirst();
                deque.addLast(s.charAt(i));
            }
        }
        max = Math.max(max, deque.size());
        return max;
    }
}
