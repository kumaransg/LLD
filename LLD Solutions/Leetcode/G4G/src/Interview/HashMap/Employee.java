package Interview.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Employee {
    private String name;
    static int value =10;
    static List<Integer> ls = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

    public static void main(String args[]){
        Employee emp1 = new Employee("Ajay");
        System.out.println(emp1.hashCode());
        Employee emp2 = new Employee("Ajay");
        System.out.println(emp2.hashCode());
        System.out.println(emp1.equals(emp2));
        Employee emp3 = new Employee("Ajay");
        System.out.println(emp3.hashCode());
        HashMap<Employee,Integer> hm = new HashMap<>();
        hm.put(emp1,1000);
        hm.put(emp2,2000);
        hm.put(emp3,3000);
        System.out.println(hm.size());
        emp1.value = 20;
        System.out.println(emp1.value);
        System.out.println(emp2.value);
        emp1.ls.add(2);
        emp1.ls.add(3);
        System.out.println(emp1.ls);
        emp2.ls.add(4);
        System.out.println(emp1.ls);
        System.out.println(emp2 .ls);
    }
}
