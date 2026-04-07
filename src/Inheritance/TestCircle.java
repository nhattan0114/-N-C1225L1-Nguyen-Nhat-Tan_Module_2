package Inheritance;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Cylinder cylinder =  new Cylinder();
        circle.setColor("yellow");
        circle.setRadius(2);
        System.out.println(circle.toString());
        System.out.println("Area of circle:"+circle.gerArea());
        cylinder.setColor("red");
        cylinder.setRadius(3);
        cylinder.setHeight(4);
        System.out.println(cylinder.toString());
        System.out.println("Area of cylinder: "+cylinder.gerArea());
        System.out.println("Volume of cylinder:"+cylinder.getVolume());
    }
}
