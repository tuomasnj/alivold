package guo;

import java.util.HashMap;

public class _03 {
    public static void main(String[] args) {
        int[] a=utils.createArray();
        System.out.println(findRepeatNumber(a));
    }
    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap= new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                return nums[i];
            }
            else{
                hashMap.put(nums[i],0);
            }
        }
        return 0;
    }
}
