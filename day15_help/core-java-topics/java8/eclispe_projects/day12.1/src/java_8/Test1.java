package java_8;
import static utils.CollectionUtils.*;

import java.util.HashMap;

import com.app.core.Emp;

public class Test1 {

	public static void main(String[] args) {
		//get HM of emps
		HashMap<Integer, Emp> hm=populateMap();
		//display
		hm.forEach((k,v)->System.out.println(v));

	}

}
