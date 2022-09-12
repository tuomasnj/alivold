import java.util.*;

public class CombinationSum2 {
    static List<Integer> temp = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,1,2};
        int target = 3;
        combinationSum2(nums, target);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, 0);
        return res;
    }

    public static void backTrack(int[] candidates, int target, int start, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] + sum > target){
                return;
            }
            int num = candidates[i];
            if (i > start && num == candidates[i - 1]) {
                continue;
            }
            sum += num;
            temp.add(num);
            backTrack(candidates, target, i + 1, sum);
            temp.remove((Integer) num);
            sum -= num;
        }
    }
}
