public class _1004 {
    public static void main(String[] args) {
        int[] nums={0};
        int k=0;
        int i = longestOnes(nums, k);
        System.out.println(i);
    }
    public static int longestOnes(int[] nums, int k) {
        int start=0;
        int end=0;
        int len=nums.length;
        int zeroNum=0;
        int result=0;
        while (end < len){
            if(nums[end]==0){
                zeroNum++;
            }
            while (zeroNum>k){
                if(nums[start]==0){
                    start++;
                    zeroNum--;
                }else {
                    start++;
                }
            }
            result=Math.max(end-start+1,result);
            end++;
        }
        return result;
    }
}
