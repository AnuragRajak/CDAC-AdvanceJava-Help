package lambdas1;

import java.util.HashMap;

public class PrintMap {

	public static void main(String[] args) {
		HashMap<Integer, String> hm=new HashMap<>();
		hm.put(10, "abc1");
		hm.put(100, "abc2");
		hm.put(57, "abc3");
		hm.put(63, "abc4");
		hm.put(22, "abc5");
		hm.forEach((i,s)->System.out.println(s));
		

	}

}
