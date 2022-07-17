package com.guo;

import java.util.Arrays;

public class _724 {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3};
        int i = pivotIndex(a);
        System.out.println(i);
    }
    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int[] s=new int[nums.length+1];
        s[0]=0;
        for (int i = 0; i < nums.length; i++) {
            if(2*s[i]+ nums[i] ==sum){
                return i;
            }
            s[i+1]=s[i]+nums[i];
        }
        return -1;
    }
}
