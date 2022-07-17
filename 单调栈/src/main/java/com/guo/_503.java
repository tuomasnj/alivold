package com.guo;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _503 {
    public static void main(String[] args) {
        int[] array = utils.createArray();
        System.out.println(Arrays.toString(nextGreaterElements(array)));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int[] result=new int[len];
        Arrays.fill(result,-1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < len-1; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }
}
