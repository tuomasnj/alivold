package guo;

public class _53_2 {
    public static void main(String[] args) {
        int[] arr=utils.createArray();
        System.out.println(missingNumber(arr));
    }
    public static int missingNumber(int[] nums) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(index != nums[i]){
                return index;
            }
            ++index;
        }
        return nums.length;
    }
}
