package CleanCode;

import CleanCode.view.CustomerView;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("\n-------Ứng dụng quản lí-------");
            System.out.println("1.Quản lí khách sạn");
            System.out.println("2.Quản lí nhà hàng");
            System.out.println("3.Quản lí thư viện");
            System.out.println("4.Thoát");
            System.out.print("Lựa chọn:> ");
            int choice =Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    customerView.mainMenuKhachSan();
                    break;
                case 2:
                    customerView.mainMenuNhaHang();
                    break;
                case 3:
                    customerView.mainMenuThuVien();
                    break;
                case 4:
                    System.exit(1);
                default:
                    System.out.println("Lựa chọn không hợp lệ,thử lại! ");
            }
        }
    }
}
