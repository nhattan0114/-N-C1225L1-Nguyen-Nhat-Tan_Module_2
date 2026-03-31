package Class_and_Object;

public class MainFan {
    public static void main(String[] args) {
        Fan newFan1 = new Fan();
        Fan newFan2 = new Fan();
        newFan1.setSpeed(newFan1.getFAST());
        newFan1.setOn(true);
        newFan1.setRadius(10);
        newFan1.setColor("yellow");
        System.out.println(newFan1.toString());
        newFan2.setSpeed(newFan2.getMEDIUM());
        System.out.println(newFan2.toString());
        System.out.println(newFan2.getSpeed());
    }
}
