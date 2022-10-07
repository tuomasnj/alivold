import java.util.ArrayList;
import java.util.List;

public class FindSequence {
    public static void main(String[] args) {
        //输出和为 n 的连续自然数子序列
        int n = 100;
        List<List<Integer>> res = findSequence(n);
        for(List<Integer> item : res){
            System.out.println(item);
        }
    }
    public static List<List<Integer>> findSequence(int n){
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int left = 1;
        int right;
        int sum = 0;
        for (right = 1; right < n ; right ++) {
            while (sum >= n){
                if(sum == n){
                    res.add(new ArrayList<>(temp));
                    break;
                }
                sum -= left;
                temp.remove((Integer) left);
                left ++;
            }
            sum += right;
            temp.add(right);
        }
        return res;
    }
}
