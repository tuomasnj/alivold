package guo;

import java.util.*;

public class GetImportance {
    static int res = 0;
    public static void main(String[] args) {
        Employee employee1 = new Employee(1,5,Arrays.asList(2,3));
        Employee employee2 = new Employee(2,3,Arrays.asList());
        Employee employee3 = new Employee(3,3,Arrays.asList());
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
        System.out.println(getImportance(employees, 1));
    }
    public static int getImportance(List<Employee> employees, int id){
        HashMap<Integer, Employee> map =new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        dfs(map, id);
        return res;
    }
    public static void dfs(HashMap<Integer, Employee> map, int id){
        if(!map.containsKey(id)){
            return;
        }
        res += map.get(id).importance;
        for (int i = 0; i < map.get(id).subordinates.size(); i++) {
            dfs(map, map.get(id).subordinates.get(i));
        }
        return;
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

