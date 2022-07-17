public class BSearch {
    public static void main(String[] args) {
        int[] a = {5, 7, 8, 10, 12, 35, 38, 100, 101};
        System.out.println(binarySearch1(a, 5, 0, a.length - 1));
        System.out.println(binarySearch2(a, 5));
    }

    public static int binarySearch1(int[] nums, int target, int left, int right) {
        if (nums[left] > target || nums[right] < target) {
            return -1;
        }
        if (left > right) return -1;
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch1(nums, target, left + 1, mid);
        } else {
            return binarySearch1(nums, target, mid, right - 1);
        }
    }

    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left+right)/2;
            if (nums[left] > target) return -1;
            if (nums[right] < target) return -1;
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            if (nums[mid] >= target) right = mid;
            else {
                left=mid+1;
            }
        }
        return -1;
    }
}
