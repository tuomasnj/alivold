import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(getMinSwap(nums));
    }
    public static int getMinSwap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int[] sortNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortNums);
        for (int i = 0; i < sortNums.length; i++) {
            map.put(sortNums[i], i);
        }
        boolean[] visited = new boolean[sortNums.length];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]){
                continue;
            }
            int j = i;
            while (!visited[j]){
                visited[j] = true;
                j = map.get(nums[j]);
            }
            cnt++;
        }
        return nums.length - cnt;
    }
}
