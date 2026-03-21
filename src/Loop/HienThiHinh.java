package Loop;

import java.util.Scanner;

public class HienThiHinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isContinue=true;
        int choice;
        do {
            System.out.println("1.Print the rectangle");
            System.out.println("2.Print the square triangle");
            System.out.println("3.Print isosceles triangle");
            System.out.println("4.Exit");
            System.out.print("Choice:>");
            choice = sc.nextInt();
            switch (choice){
                case 1:{
                    System.out.print("Nhập số hàng: ");
                    int rows =sc.nextInt();
                    System.out.print("Nhập số cột: ");
                    int cols = sc.nextInt();

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                }
                break;
                case 2:{
                    System.out.println("1.Top-left");
                    System.out.println("2.Bottom-left");
                    System.out.println("3.Top-right");
                    System.out.println("4.Bottom-right");
                    System.out.print("Choice:>");
                    int type=sc.nextInt();
                    switch (type){
                        case 1:
                            for (int i = 3; i >= 1; i--) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            for (int i = 1; i <= 3; i++) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 3:
                            for (int i = 4; i >= 1; i--) {
                                for (int j = 1; j <= 4 - i; j++) {
                                    System.out.print("  ");
                                }
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 4:
                            for (int i = 1; i <= 3; i++) {
                                // space
                                for (int j = 1; j <= 3 - i; j++) {
                                    System.out.print("  ");
                                }
                                // star
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        default:
                            System.out.println("Invalid choice,try again!");
                    }
                }
                break;
                case 3:
                    for (int i = 1; i <= 5; i++) {
                        // space
                        for (int j = 1; j <= 5 - i; j++) {
                            System.out.print(" ");
                        }
                        // star
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    isContinue=false;

            }
        }while(isContinue);
        System.out.println("Exit successfully!!!");
    }
}
