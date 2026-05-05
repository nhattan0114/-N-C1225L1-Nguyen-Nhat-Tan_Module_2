package exception;

import java.util.Scanner;

public class testTriangle {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("======Kiểm tra tam giác=====");
        try{
            double a=inputDouble("Nhập cạnh thứ nhất");
            double b=inputDouble("Nhập cạnh thứ hai");
            double c=inputDouble("Nhập cạnh thứ ba");

            checkTriangle(a,b,c);
        }catch (IllegalTriangleException e){
            System.err.println("Ngoại lệ tam giác: "+e.getMessage());
        }
    }

    public static double inputDouble(String mes){
        while (true){
            try {
                System.out.print(mes+": ");
                return Double.parseDouble(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số!");
            }
        }
    }
    public static void checkTriangle(double a,double b,double c)throws IllegalTriangleException{
        if (a<=0||b<=0||c<=0){
            throw new IllegalTriangleException("Lỗi: Các cạnh của tam giác phải là số dương lớn hơn 0");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Lỗi: Tổng hai cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }

        System.out.println("Thành công: 3 giá trị vừa nhập tạo thành một tam giác hợp lệ!");
    }


}
