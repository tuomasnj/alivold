package com.guo;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _739 {
    public static void main(String[] args) {
        int[] arr=utils.createArray();
        int[] ints = dailyTemperatures(arr);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        int[] result=new int[len];
        Deque<Integer> deque=new LinkedList<Integer>();
        for (int i = 0; i < len ; i++) {
            while(!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()])
            {
                int index =deque.pop();
                result[index] = i- index;
            }
            deque.push(i);
        }
        return result;
    }
}
