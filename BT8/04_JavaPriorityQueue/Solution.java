import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.StringTokenizer;
class Student{
    private int id;
    private String name;
    private double cgpa;
    public Student(String fname, double cgpa, int id) {
        super();
        this.id = id;
        this.name = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        if (a.getCgpa() != b.getCgpa()) {
            return Double.compare(b.getCgpa(), a.getCgpa());
        }
        
        if (!a.getName().equals(b.getName())) {
            return a.getName().compareTo(b.getName());
        }
        
        return Integer.compare(b.getId(), a.getId());
    }
} 

class Priorities {
    
    public List<Student> getStudents(List<String> events) {
        
        List<Student> students = new ArrayList<>();
        
        boolean sorted = false;
        
        for (String event : events) {
            
           
            
            StringTokenizer st = new StringTokenizer(event);
            
            switch(st.nextToken()) {
                case "ENTER":
                    students.add(new Student(st.nextToken(), Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken())));
                    sorted = false;
                    break;
                case "SERVED":
                    if (!sorted && students.size() > 1) {
                        Collections.sort(students, new StudentComparator());
                        sorted = true;
                    }
                    if (!students.isEmpty()) {
                        students.remove(0);
                    }
                    break;    
            }
            
        }
        
        return students;
    }
    
}





public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}