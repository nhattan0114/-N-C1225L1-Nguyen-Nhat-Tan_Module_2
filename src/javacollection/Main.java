package javacollection;

import javacollection.view.ProductView;

public class Main {
    public static void main(String[] args) {
        ProductView productView = new ProductView();
        while (true) {
            System.out.println("------------------WELCOME-----------------");
            System.out.println("1.Chạy chương trình.");
            System.out.println("2.Thoát");
            System.out.println("------------------------------------------");
            int choice = productView.inputInterger("Lựa chọn: ");
            switch (choice) {
                case 1: productView.run();
                break;
                case 2: System.exit(0);
                default: System.out.println("Vui lòng nhập lựa chọn hợp lệ!");
            }
        }
    }
}
