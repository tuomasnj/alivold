public class _45 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,1,4};
        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = 0;
        int jumpLength = 0;
        int indexOfCur = 0;
        int jumpTime = 0;
        int numLen = nums.length;
        while (jumpLength < numLen - 1) {
            int next = nums[indexOfCur];
            int NextIndex = indexOfCur;
            for (int i = indexOfCur + 1; i <= indexOfCur + next && i <= numLen - 1; i++) {
                int preMax = max;
                max = Math.max(max, nums[i] + i - indexOfCur);
                if (max != preMax ||nums[i] + i - indexOfCur==max) {
                    NextIndex = i;
                }
                if (NextIndex >= numLen - 1 || indexOfCur+nums[indexOfCur]>=numLen-1) {
                    jumpTime++;
                    return jumpTime;
                }
            }
            jumpTime++;
            jumpLength += NextIndex-indexOfCur;
            indexOfCur=NextIndex;
            max=0;
        }
        return jumpTime;
    }
}
