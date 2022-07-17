import java.util.ArrayList;
import java.util.List;

public class _46 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        List<List<Integer>> permute = permute(nums);
        for(List<Integer> list: permute){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        helper(nums,res,temp);
        return res;
    }
    public static void helper(int[] nums,List<List<Integer>> res,List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])){
                continue;
            }else {
                temp.add(nums[i]);
                helper(nums,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
