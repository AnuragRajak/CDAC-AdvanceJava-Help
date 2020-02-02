package java_8;

import static utils.CollectionUtils.populateList;

import java.util.List;

import com.app.core.Emp;

public class Test3 {

	public static void main(String[] args) {
		List<Emp> l1 = populateList();
		// avg of rnd dept's salary
		double avgSal = l1.stream().filter(e -> e.getDept().equals("rnd")).mapToDouble(e -> e.getSalary()).average()
				.getAsDouble();
		System.out.println(avgSal);

	}

}
