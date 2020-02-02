package utils;

import static utils.StudentUtils.convertDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.app.core.Student;
import com.app.core.Subject;

public class StudentUtils {
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}

	// string ---> date conversion
	public static Date convertDate(String s) throws Exception {
		return sdf.parse(s);
	}

	public static ArrayList<Student> populateData() throws Exception {
		ArrayList<Student> l1 = new ArrayList<>();
		l1.add(new Student("dbda-1", "abc1", convertDate("22/3/1999"), 5.6, Subject.CLOUD));
		l1.add(new Student("dbda-11", "abc11", convertDate("2/4/1997"), 8.6, Subject.JAVA));
		l1.add(new Student("dbda-5", "abc5", convertDate("22/3/1999"), 7.6, Subject.JAVA));
		l1.add(new Student("dbda-8", "abc8", convertDate("2/5/1995"), 9.6, Subject.JAVA));
		return l1;
	}
}
