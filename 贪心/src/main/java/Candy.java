public class Candy {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        System.out.println(candy(nums));
    }

    public static int candy(int[] ratings) {
        int ans = 0;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if(i > 0 && ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }else {
                left[i] = 1;
            }
        }
        for (int i = ratings.length - 1; i >= 0; i--) {
            if(i < ratings.length - 1 && ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }else {
                right[i] = 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }
}
