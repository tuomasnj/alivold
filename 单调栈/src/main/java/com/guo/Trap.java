package com.guo;
import java.util.Stack;

public class Trap {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        System.out.println(trap(nums));
    }

    public static int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int ground = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[ground]) {
                    stack.pop();
                }
                if(stack.size() >= 1){
                    int leftIndex = stack.peek();
                    int tall = Math.min(height[leftIndex], height[i]);
                    res += (i - leftIndex - 1) * (tall - height[ground]);
                }
            }
            stack.add(i);
        }
        return res;
    }
}
