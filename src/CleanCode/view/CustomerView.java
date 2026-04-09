package CleanCode.view;

import CleanCode.controller.CustomerController;
import CleanCode.entity.Customer;


import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {
    CustomerController customerController = new CustomerController();

    public  void mainMenu(){
        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println("1.Danh sach khach cua khach san");
            System.out.println("2.Them moi khanh hang");
            System.out.println("3.Xoa khach hang");
            System.out.println("4.Tim kiem theo ten");
            System.out.println("5.Thoat");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    ArrayList<Customer> list= customerController.getList();
                    for (Customer cus : list){
                        System.out.println(cus.toString());
                    }
                    break;
                case 2: break;
                case 3: break;
                case 4:break;
                case 5:
                    System.out.println("Tro lai menu chinh.");
                    return;
            }
        }

    }
}
