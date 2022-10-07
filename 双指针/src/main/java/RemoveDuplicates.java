public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums){
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int left = 1, right = 1;
        while (right < n){
            if(nums[right] != nums[right - 1]){
                nums[left] = nums[right];
                left ++;
            }
            right ++;
        }
        return left;
    }
}
