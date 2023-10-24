import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        if (a.getCgpa() != b.getCgpa()) {
            return Double.compare(b.getCgpa(), a.getCgpa());
        }
        
        if (!a.getFname().equals(b.getFname())) {
            return a.getFname().compareTo(b.getFname());
        }
        
        return Integer.compare(b.getId(), a.getId());
    }
} 

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        // Collections.sort(studentList, Comparator.comparing(Student::getCgpa).reversed()
        // .thenComparing(Student::getFname).thenComparing(Student::getId));
        
        Collections.sort(studentList, new StudentComparator());
      
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}



