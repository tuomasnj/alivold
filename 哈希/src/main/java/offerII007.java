import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offerII007 {
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        List<List<Integer>> list = threeSum(nums);
        for(List<Integer> ans: list){
            System.out.println(ans);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length==0)return new ArrayList<>(new ArrayList<>());
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int NeedRes = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == NeedRes) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while ((left + 1 < right) && (nums[left + 1] == nums[left])) {
                        left++;
                    }
                    left++;
                    while ((right - 1 > left) && (nums[right - 1] == nums[right])) {
                        right--;
                    }
                    right--;
                } else if (nums[left] + nums[right] > NeedRes) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
