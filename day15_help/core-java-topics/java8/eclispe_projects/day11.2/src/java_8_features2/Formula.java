package java_8_features2;
interface Formula {
    double calculate(double a);

    default double sqrt(double a,double b) {
    	System.out.println("in def method imple1");
        return Math.sqrt(a+b);
    }
}
