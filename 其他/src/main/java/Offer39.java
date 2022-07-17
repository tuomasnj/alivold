public class Offer39 {
    public static void main(String[] args) {
        int[] nums = new int[]{8,8,6,7,7,8};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int vote = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(vote == 0){
                res = nums[i];
                vote ++;
            }else {
                if(nums[i] == res){
                    vote++;
                }else {
                    vote--;
                }
            }
        }
        return res;
    }
}
