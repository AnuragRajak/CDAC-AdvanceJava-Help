package java_8_features;

public class Test1 {

	public static void main(String[] args) {
		Formula f1=new MyFormula();
		f1.calculate(10);
		System.out.println(f1.sqrt(16,9));

	}

}
