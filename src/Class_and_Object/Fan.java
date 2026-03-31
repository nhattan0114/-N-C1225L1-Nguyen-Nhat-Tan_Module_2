package Class_and_Object;

public class Fan {
    private  final  int SLOW =1;
    private  final int MEDIUM =2;
    private  final int FAST =3;
    private int speed=1 ;
    private double radius=5;
    private String color="blue";
    private boolean on =false;


    public Fan() {
    }


    public int getFAST() {
        return FAST;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getSLOW() {
        return SLOW;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public String toString() {
        if (on) {
            return "Fan is on | Speed: " + speed + " | Color: " + color + " | Radius: " + radius;
        } else {
            return "Fan is off | Color: " + color + " | Radius: " + radius;
        }
    }
}
