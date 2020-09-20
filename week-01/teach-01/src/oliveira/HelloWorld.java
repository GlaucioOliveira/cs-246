package oliveira;

public class HelloWorld {

    public void sayHello(){
        System.out.println("Hello World!!!");
    }

    public static void main(String[] args) {
	// write your code here
        new HelloWorld().sayHello();

        CircleCalculator c = new CircleCalculator();
        Double radius = c.getRadius();

        Double area = c.displayArea(radius);
        Double circurm = c.displayCircumference(radius);

    }
}
