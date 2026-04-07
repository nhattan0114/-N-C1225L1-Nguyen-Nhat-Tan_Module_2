package AbstractClass_Interface;
import java.util.Random;
public class MainResize {
    public static void main(String[] args) {
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(10, 20);
        shapes[2] = new Square(15);

        Random random = new Random();

        System.out.println("--- KẾT QUẢ THAY ĐỔI KÍCH THƯỚC ---");

        for (Resizeable shape : shapes) {
            String shapeName = shape.getClass().getSimpleName();

            double areaBefore = 0;
            if (shape instanceof Circle) areaBefore = ((Circle) shape).getArea();
            if (shape instanceof Rectangle) areaBefore = ((Rectangle) shape).getArea();
            if (shape instanceof Square) areaBefore = ((Square) shape).getArea();

            double percent = 1 + random.nextInt(100);

            shape.resize(percent);

            double areaAfter = 0;
            if (shape instanceof Circle) areaAfter = ((Circle) shape).getArea();
            if (shape instanceof Rectangle) areaAfter = ((Rectangle) shape).getArea();
            if (shape instanceof Square) areaAfter = ((Square) shape).getArea();

            System.out.printf("Hình: %s\n", shapeName);
            System.out.printf("- Tỉ lệ tăng: %.2f%%\n", percent);
            System.out.printf("- Diện tích trước: %.2f\n", areaBefore);
            System.out.printf("- Diện tích sau:  %.2f\n", areaAfter);
            System.out.println("----------------------------------");
        }
    }
    }

