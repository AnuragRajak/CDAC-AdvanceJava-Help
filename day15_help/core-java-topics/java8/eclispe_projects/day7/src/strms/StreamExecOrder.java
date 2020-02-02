package strms;

import static utils.StudentUtils.populateData;

import java.util.ArrayList;

import com.app.core.Student;
import com.app.core.Subject;

public class StreamExecOrder {

	public static void main(String[] args) throws Exception {
		/*
		 * What will be o/p ?
		 */
		ArrayList<Student> students = populateData();
		long count=students.stream().filter(s -> {
			System.out.println("filtering");
			return s.getSubject() == Subject.JAVA;
		}).mapToDouble(s -> {
			System.out.println("mapping");
			return s.getGpa();
		}).count();
		System.out.println(count);
	}

}
