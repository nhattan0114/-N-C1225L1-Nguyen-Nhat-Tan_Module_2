package Inheritance;

public class TestPoint {
    public static void main(String[] args) {
        Point2D p2 = new Point2D(1.5f, 2.5f);
        System.out.println("Point 2D: " + p2.toString());

        Point3D p3 = new Point3D(1.0f, 2.0f, 3.0f);
        System.out.println("Point 3D: " + p3.toString());
        float[] coords = p3.getXYZ();
        System.out.print("Mảng tọa độ 3D: ");
        for (float f : coords) System.out.print(f + " ");
    }
}
