package thithuchanhmodule2;

import thithuchanhmodule2.controller.Controller;
import thithuchanhmodule2.view.view;



public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        int choice;
        while (true){
            System.out.println("\n==========Xin chào==========");
            System.out.println("======Chương trình quản lí bệnh án======");
            System.out.println("1.Xem danh sách các bệnh án.");
            System.out.println("2.Thêm mới .");
            System.out.println("3.Xóa.");
            System.out.println("4.Thoát");
            choice =view.inputInterger("Lựa chọn");
            switch (choice){
                case 1:
                    view.printBenhAn(controller.getBenhAnList());
                    break;
                case 2:
                    if (controller.addBenhAn(view.addBenhAn())){
                        System.out.println("Thêm mới thành công!");
                    }
                    else {
                        System.out.println("Thêm mới thất bại!");
                    }
                    break;
                case  3:
                    controller.deleteBenhAn();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Sai cú pháp vui lòng thử lại!");
            }
        }
    }


}
