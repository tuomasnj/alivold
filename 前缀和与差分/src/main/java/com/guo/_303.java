package com.guo;
public class _303 {
    public static void main(String[] args) {
        int[] num={5,6,4,20,63};
        NumArray numArray = new NumArray(num);
        System.out.println(numArray.sumRange(0,4));
    }
}
class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1]=sum[i]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right+1]-sum[left];
    }
}
