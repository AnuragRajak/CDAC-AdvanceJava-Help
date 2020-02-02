package strms;

import static utils.StudentUtils.populateData;

import java.util.ArrayList;

import com.app.core.Student;
import com.app.core.Subject;

public class Test4 {

	public static void main(String[] args)throws Exception{
		/*
		 * Create Subject enum --JAVA,CLOUD,ML,R ....
		 * Add this Subject as data member of student.
		 * Modify constr & to string.
		 * Print avg gpa of students opted for subject JAVA
		 */
		ArrayList<Student> students=populateData();
		double val=students.stream().
				filter(s->s.getSubject()==Subject.JAVA).
				mapToDouble(s->s.getGpa()).average().
				getAsDouble();
		System.out.println("avg gpa "+val);
	}

}
