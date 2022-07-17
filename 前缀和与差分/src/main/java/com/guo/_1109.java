package com.guo;

import java.util.Arrays;

public class _1109 {
    public static void main(String[] args) {
        int n = 5;
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] ints = corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int size = bookings.length;
        int[] diff = new int[n];
        //计算差分数组
        for (int i = 0; i < size; i++) {
            diff[bookings[i][0]-1] = diff[bookings[i][0]-1] + bookings[i][2];
            if (bookings[i][1] != n) {
                diff[bookings[i][1]] = diff[bookings[i][1]] - bookings[i][2];
            }
        }
        //求差分数组的前缀和，得到座位总数
        for (int i = 1; i < n; i++) {
            diff[i]+=diff[i-1];
        }
        return diff;
    }
}
