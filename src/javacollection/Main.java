package javacollection;

import javacollection.view.ProductView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductView productView = new ProductView();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------------------WELCOME-----------------");
            System.out.println("1.Chạy chương trình.");
            System.out.println("2.Thoát");
            System.out.println("------------------------------------------");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: productView.run();
                break;
                case 2: System.exit(1);
                default: System.out.println("Sai cú pháp,thử lại!");
            }
        }
    }
}
