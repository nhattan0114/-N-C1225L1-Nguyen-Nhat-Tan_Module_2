package Class_and_Object;

public class QuadracticEquation {
    private double a;
    private double b;
    private double c;

    public QuadracticEquation() {
    }

    public QuadracticEquation(double a,double b,double c) {
        this.a = a;
        this.b=b;
        this.c=c;
    }

    public double getB() {
        return b;
    }

    public double getA() {
        return a;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant(double a,double b,double c){
        return Math.pow(b,2)-4*a*c;
    }

    public double getRoot1(double delta,double a,double b){
        if(delta <0){
            return 0;
        }
        else{
            return (-b + Math.pow(delta,0.5))/2*a;
        }
    }

    public double getRoot2(double delta,double a,double b){
        if(delta <0){
            return 0;
        }
        else{
            return (-b - Math.pow(delta,0.5))/2*a;
        }
    }
}
