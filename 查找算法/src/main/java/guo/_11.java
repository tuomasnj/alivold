package guo;

import java.util.Arrays;

public class _11 {
    public static void main(String[] args) {
        int[] arr=utils.createArray();
        System.out.println(Arrays.toString(arr));
        System.out.println(minArray(arr));
    }
    public static int minArray(int[] numbers) {
        int left=0;
        int right=numbers.length-1;
        int mid=left+(right-left)/2;
        while(left < right)
        {
            if(numbers[mid]<numbers[left]){
                right=mid;
            }
            else if(numbers[mid]>numbers[right]){
                left=mid+1;
            }
            else{
                right--;
            }
            mid=left+(right-left)/2;
        }
        return numbers[left];
    }
}
