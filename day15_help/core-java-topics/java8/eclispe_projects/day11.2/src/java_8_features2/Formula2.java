package java_8_features2;
interface Formula2 {
    double calculate(double a);

    default double sqrt(double a,double b) {
    	System.out.println("in def method imple2");
        return Math.sqrt(a-b);
    }
}
