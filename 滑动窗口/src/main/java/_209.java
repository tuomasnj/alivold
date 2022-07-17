public class _209 {

    public static void main(String[] args) {
        int[] nums;
        nums=new int[]{2,3,1,2,4,3};
        int i = minSubArrayLen(7, nums);
        System.out.println(i);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int min=Integer.MAX_VALUE;
        int length= right-left+1;
        int total= nums[0];
        while (left<nums.length){
            if(total < target){
                right ++;
                if(right==nums.length){
                    break;
                }
                total+=nums[right];
                length++;
            }else{
                total-=nums[left];
                left ++;
                min=Math.min(min,length);
                length--;
            }
        }
        return min==Integer.MAX_VALUE? 0 : min;
    }
}
