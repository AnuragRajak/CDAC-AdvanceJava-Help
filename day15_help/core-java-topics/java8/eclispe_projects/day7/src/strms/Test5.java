package strms;

import static utils.StudentUtils.populateData;

import java.util.ArrayList;
import java.util.Comparator;

import com.app.core.Student;
import com.app.core.Subject;

public class Test5 {

	public static void main(String[] args) throws Exception {
		/* name of java topper */
		ArrayList<Student> students = populateData();
		Comparator<Student> comp=
				(s1,s2)->((Double)s1.getGpa()).
				compareTo(s2.getGpa());
		String topperName=students.stream().
				filter(s->s.getSubject()==Subject.JAVA).
				max(comp).get().getName();
		System.out.println(topperName);
	}

}
