package AbstractClass_Interface;

public class Rectangle implements Resizeable{
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    @Override
    public void resize(double percent) {
        this.width *= (1 + percent / 100);
        this.length *= (1 + percent / 100);
    }
}
