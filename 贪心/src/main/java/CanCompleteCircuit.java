public class CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = {6, 1};
        int[] cost = {1, 5};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int redundant = 0;
        int index = 0;
        int minRedundant = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            if (redundant < minRedundant) {
                minRedundant = redundant;
                index = i;
            }
            redundant = redundant + gas[i] - cost[i];
        }
        if(redundant >= 0){
            return index;
        }else {
            return -1;
        }
    }
}
