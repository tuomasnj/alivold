public class MinEatingSpeed {
    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        int res = minEatingSpeed(piles, h);
        System.out.println(res);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        for(int num : piles){
            high = Math.max(high , num);
        }
        while (low < high){
            int mid = low + (high - low) / 2;
            int time = completeHour(piles , mid);
            if(time <= h){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int completeHour(int[] piles, int speed) {
        int time = 0;
        for (int num : piles) {
            time += num % speed ==0? num / speed : num / speed + 1;
        }
        return time;
    }
}
