public class offerII009 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        System.out.println(numSubarrayProductLessThanK(nums, 8));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int product = 1;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k && start <= i) {
                product /= nums[start];
                start++;
            }
            count += i - start + 1;
        }
        return count;
    }
}
