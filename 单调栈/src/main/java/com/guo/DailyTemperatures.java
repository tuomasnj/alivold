package com.guo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {30,60,90};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (!deque.isEmpty()) {
                while (!deque.isEmpty() && temperatures[deque.peekFirst()] < temperatures[i]) {
                    res[deque.peekFirst()] = i - deque.pop();
                }
            }
            deque.push(i);
        }
        return res;
    }
}
