package com.guo;

import java.util.Arrays;

public class _1094 {
    public static void main(String[] args) {
        int[][] trips = new int[][]{{9, 0, 1}, {3, 3, 7}};
        System.out.println(carPooling(trips, 4));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        int[] diff = new int[1001];
        for (int[] cell : trips) {
            diff[cell[1]] = diff[cell[1]] + cell[0];
            diff[cell[2]] = diff[cell[2]] - cell[0];
            max = Math.max(cell[1], max);
        }
        System.out.println(Arrays.toString(diff));
        if (diff[0] > capacity) return false;
        for (int i = 1; i <= max; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}

