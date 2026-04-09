package CleanCode;

import CleanCode.view.CustomerView;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1.Quan li khach San");
            System.out.println("2.Quan li nha hang");
            System.out.println("3.Quan li thu vien");
            System.out.println("4.Thoat");
            System.out.println("Lua chon:> ");
            int choice =Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    customerView.mainMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(1);
            }
        }
    }
}
