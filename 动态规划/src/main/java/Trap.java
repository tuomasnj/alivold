public class Trap {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[right.length - 1] = height[right.length - 1];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < left.length; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        String s = "kkk";
        return ans;
    }
}
