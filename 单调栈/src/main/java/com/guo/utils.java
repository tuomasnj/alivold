package com.guo;
import java.util.Scanner;

public class utils {
    //创建一个数组
    public static int[] createArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("数组的长度：");
        int len = sc.nextInt();
        int[] a = new int[len];
        System.out.println("请输入整数：");
        int count = 0;
        while (count < len) {
            a[count] = sc.nextInt();
            ++count;
        }
        return a;
    }
}
