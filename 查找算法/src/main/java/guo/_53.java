package guo;

public class _53 {
    public static void main(String[] args) {
        int[] a=utils.createArray();
        int search = search(a, 10);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        return helper(nums,target)-helper(nums,target-1);
    }

    //查找target与target-1的右边界
    public static int helper(int[] nums, int tar) {
        int len=nums.length;
        int left=0;
        int right=len-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=tar){
                left++;
            }else {
                right--;
            }
        }
        return left;
    }
}
