package oliveira;

import java.util.Scanner;
import java.lang.Math;

public class CircleCalculator {
    public double getRadius(){
        Scanner s = new Scanner(System.in);

        System.out.print("Type the Radius: ");
        double radius = s.nextDouble();
        return radius;
    }

    public double displayCircumference(double radius){
        return 2 * Math.PI * radius;
    }

    public double displayArea(double Radius){
        return Math.PI * (Math.pow(Radius, 2));
    }
}
