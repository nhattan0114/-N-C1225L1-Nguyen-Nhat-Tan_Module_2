package Inheritance;

public class Cylinder extends Circle{
    private double height;

    public Cylinder( ) {
    }

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double gerArea() {
        return 2*Math.PI*super.getRadius()*this.height+2*Math.PI*Math.pow(super.getRadius(),2);
    }
    public double getVolume(){
        return Math.PI*Math.pow(super.getRadius(),2)*this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{radius: "+super.getRadius()+
                " , height: "+this.height+
                " , color: "+super.getColor()+"}";
    }
}
