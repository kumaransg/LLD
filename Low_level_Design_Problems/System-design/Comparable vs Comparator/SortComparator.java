package oops3;
import java.util.*;

class Student {
	int rollno;
	String name;
	String address;
	
	Student(int roll, String n, String add) {
		this.address = add;
		this.rollno = roll;
		this.name = n;
	}
	
	public String toString() {
        return this.rollno + " " + this.name +
                           " " + this.address;
    }
}

class SortbyRollNo implements Comparator<Student> {
	 // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b)
    {
        return a.rollno - b.rollno;
    }
}

class SortbyName implements Comparator<Student> {
	public int compare(Student a, Student b) {
		return a.name.compareTo(b.name);
	}
}
public class SortComparator {
	public  static void main(String args[]) {
		ArrayList<Student> al = new ArrayList<Student> ();
		Student s1 = new Student(101, "Abhimanyu Sharma", "Talwara Township");
		Student s2 = new Student(100, "Udit Sharma", "Chandigarh");
		Student s3 = new Student(102, "Kartik", "Bathinda");
		Student s4 = new Student(104, "Abhishek katyal", "Delhi");
		Student s5 = new Student(103, "Rishabh Khanna", "Sirmaur");
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		al.add(s5);
		
		System.out.println("Before sorting objects\n");
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		System.out.println("After sorting objects on the basis of roll number\n");
		Collections.sort(al, new SortbyRollNo());
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		System.out.println("After sorting objects on the basis of name \n");
		Collections.sort(al, new SortbyName());
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
	}
}
