import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * 对泛型的测试
 */
public class Test {
    public static void main(String[] args) {
        List<? super Object> list1=new ArrayList<>(); //[-无穷,Person]
        list1.add(new Student("小明"));
        Object object = list1.get(0);
        System.out.println(((Student)object).name);
    }
}
class  Person{
    String name;

    public Person(String name) {
        this.name = name;
    }
}
class  Student extends Person{
    public Student(String name) {
        super(name);
    }
}
