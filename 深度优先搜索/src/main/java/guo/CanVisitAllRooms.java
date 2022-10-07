package guo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanVisitAllRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList());
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    public static void dfs(Integer roomNumber, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[roomNumber]) {
            return;
        }
        visited[roomNumber] = true;
        List<Integer> keys = rooms.get(roomNumber);
        int size = keys.size();
        for (int i = 0; i < size; i++) {
            dfs(keys.get(i), rooms, visited);
        }
    }
}
