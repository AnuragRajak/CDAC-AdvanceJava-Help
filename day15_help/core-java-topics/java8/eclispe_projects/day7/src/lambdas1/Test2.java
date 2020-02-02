package lambdas1;

import static utils.StudentUtils.*;

import java.util.ArrayList;
import java.util.Comparator;

import com.app.core.Student;

public class Test2 {

	public static void main(String[] args) throws Exception {
		// display student list
		ArrayList<Student>l1=populateData();
		System.out.println("Student names");
		l1.forEach(s -> System.out.println(s.getName()));
		// remove stduents having gpa < 8
//		l1.removeIf(s->s.getGpa()<8);
		System.out.println("display student dtls");
		l1.forEach(s -> System.out.println(s));
		// sort students by gpa
		Comparator<Student> comp = 
				(s1, s2) -> ((Double) s1.getGpa()).compareTo(s2.getGpa());
		l1.sort(comp);
		System.out.println("sorted dtls");
		l1.forEach(s->System.out.println(s));
//;
		/*
		 * { if (s1.getGpa() < s2.getGpa()) return -1; if (s1.getGpa() == s2.getGpa())
		 * return 0; return 1; };
		 */

	}

}
