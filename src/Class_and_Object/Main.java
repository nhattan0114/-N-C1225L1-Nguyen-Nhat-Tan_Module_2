package Class_and_Object;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuadracticEquation test = new QuadracticEquation();
        Scanner sc = new Scanner(System.in);
        double a;
        double b;
        double c;
        System.out.print("Enter a, b , c: ");
        a= sc.nextDouble();
        b=sc.nextDouble();
        c=sc.nextDouble();
        double delta=test.getDiscriminant(a,b,c);
        double result1=test.getRoot1(delta,a,b);
        double result2=test.getRoot2(delta,a,b);
        if (delta==0){
            System.out.printf("The equation has one root %.2f",result1);
        } else if (delta>0) {
            System.out.printf("The equation has two root %.2f and %.2f",result1,result2);
        }else{
            System.out.println("The equation has no real roots");
        }

    }
}
