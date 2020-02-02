package lambdas1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tester3 {

	public static void main(String[] args) {
		List<Integer> l1=Arrays.asList(10,1,34,45,20,67,1);
		System.out.println(l1);
	/*	Collections.sort(l1,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
			
				return o2.compareTo(o1);
			}
		
		});*/
		
		//OR
	//	Collections.sort(l1,(i1,i2)->i2.compareTo(i1));
		//OR
		Comparator<Integer> comp=(i1,i2)->i2.compareTo(i1);
		Collections.sort(l1,comp);
		System.out.println(l1);
	}

}
