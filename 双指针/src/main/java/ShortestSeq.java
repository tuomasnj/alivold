import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestSeq {
    public static void main(String[] args) {
        int[] big = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] small = {1,5,9};
        System.out.println(Arrays.toString(shortestSeq(big,small)));
    }

    //最短超串
    public static int[] shortestSeq(int[] big, int[] small) {
        // 最短窗口大小
        int minLength = big.length + 1;
        // 数组记录小数组每个位置元素的匹配次数
        int[] count = new int[small.length];
        // 哈希表记录小数组元素的值和对应下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < small.length; i ++) {
            map.put(small[i], i);
        }
        // 窗口左右边界
        int left = 0, right = 0;
        // 用find记录匹配的个数
        int find = 0;
        int[] res = new int[2];
        // 扩展右边界
        while (right < big.length) {
            int rightNum = big[right];
            if (map.containsKey(rightNum)) {
                count[map.get(rightNum)] ++;
                if (count[map.get(rightNum)] == 1) {
                    find ++;
                }
            }
            // 缩小左边界
            while (find == small.length) {
                if (right - left + 1 < minLength) {
                    res[0] = left;
                    res[1] = right;
                    minLength = right - left + 1;
                }
                int leftNum = big[left];
                if (map.containsKey(leftNum)) {
                    count[map.get(leftNum)] --;
                    if (count[map.get(leftNum)] == 0) {
                        find --;
                    }
                }
                left ++;
            }
            right ++;
        }
        return minLength <= big.length ? res : new int[0];
    }
}
