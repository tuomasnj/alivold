import java.util.HashMap;

public class _560 {
    public static void main(String[] args) {
        int[] nums={1,1,1};
        System.out.println(subarraySum(nums,2));
    }
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        map.put(0,1);
        int count=0;
        int[] sum=new int[nums.length+1];
        sum[0]=0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i]=sum[i-1]+nums[i-1];
            if(map.containsKey(sum[i]-k)){
                count+=map.get(sum[i]-k);
            }
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        return count;
    }
}
