import java.util.Arrays;

public class _21 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("exchange前:"+Arrays.toString(arr));
        int[] exchange = exchange(arr);
        System.out.println("exchange后:"+Arrays.toString(exchange));
    }

    public static int[] exchange(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        int left = 0, right = size - 1;
        for (int i = 0; i < size; i++) {
            if ((nums[i] & 1) == 0) {
                ans[right] = nums[i];
                right--;
            }else {
                ans[left] = nums[i];
                left++;
            }
        }
        return ans;
    }
}
