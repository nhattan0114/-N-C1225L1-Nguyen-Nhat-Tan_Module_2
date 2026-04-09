package AbstractClass_Interface.Colorable;

public class Main {
    public static void main(String[] args) {
        Square square = new Square();
        square.setSide(3);
        System.out.println("Square has side: "+square.getSide());
        System.out.println("Area of square: "+square.getArea());
        square.howToColor();
    }
}
