import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _47 {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> list = permuteUnique(arr);
        for(List<Integer> myList:list){
            System.out.println(myList);
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set=new HashSet<>();
        helper(nums,set,new ArrayList<>(),new boolean[nums.length]);
        return new ArrayList<>(set);
    }
    public static void helper(int[] nums, Set<List<Integer>> res, List<Integer> temp,boolean[] vis){
        if(temp.size()== nums.length){
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if(!vis[i]){
                vis[i] = true;
                temp.add(nums[i]);
                helper(nums,res,temp,vis);
                temp.remove(temp.size()-1);
                vis[i]=false;
            }else {
                continue;
            }
        }
    }
}
