package java_8_features3;

public class Test1 {

	public static void main(String[] args) {
		Formula f1=new MyFormula();
		f1.calculate(10);
		f1.sqrt(12, 13);
		MyFormula.test();
		Formula.test();

	}

}
