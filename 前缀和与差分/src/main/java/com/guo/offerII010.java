package com.guo;

import java.util.HashMap;

/**
 * 计算和为k的连续子数组的个数
 */
public class offerII010 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subarraySum(nums,3));
    }
    public static int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int count=0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            preSum+=nums[i];
            if(hashMap.containsKey(preSum - k)){
                count += hashMap.get(preSum - k);
            }
            hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
