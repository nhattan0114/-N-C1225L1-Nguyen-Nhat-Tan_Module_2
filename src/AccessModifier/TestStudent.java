package AccessModifier;

public class TestStudent {
    public static void main(String[] args) {
        Student stu = new Student();
        System.out.println(stu.toString());
        stu.setName("Nhat Tan");
        stu.setClasses("JDP103");
        System.out.println(stu.toString());
    }
}
