import java.util.*;

public class GetImportance {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1,5,Arrays.asList(2,3));
        Employee employee2 = new Employee(2,3,Arrays.asList());
        Employee employee3 = new Employee(3,3,Arrays.asList());
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
        System.out.println(getImportance(employees, 1));
    }
    public static int getImportance(List<Employee> employees, int id){
        int res = 0;
        HashMap<Integer, Employee> map =new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        Queue<Integer> queue =new LinkedList<>();
        queue.add(id);
        res = bfs(res, queue, map);
        return res;
    }
    public static int bfs(int res, Queue<Integer> queue, HashMap<Integer, Employee> map){
        while (!queue.isEmpty()){
            int curID = queue.poll();
            if(!map.containsKey(curID)){
                continue;
            }else {
                res += map.get(curID).importance;
                for (int i = 0; i < map.get(curID).subordinates.size(); i++) {
                    queue.add(map.get(curID).subordinates.get(i));
                }
            }
        }
        return res;
    }
}
class Employee{
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}
