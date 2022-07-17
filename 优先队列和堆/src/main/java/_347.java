import java.util.*;

public class _347 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 5, 5, 8};
        int k = 1;
        int[] ints = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hashMap.get(o1) - hashMap.get(o2);
            }
        });
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator=entries.iterator();
        while (iterator.hasNext()){
            priorityQueue.offer(iterator.next().getKey());
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        for (int i = k-1; i >=0 ; i--) {
            res[i]=priorityQueue.poll();
        }
        return res;
    }
}
