package CleanCode.view;

import CleanCode.controller.CustomerController;
import CleanCode.entity.Customer;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {
    public static Scanner sc = new Scanner(System.in);

    CustomerController customerController = new CustomerController();

    public  void mainMenuKhachSan(){
        while (true){
            System.out.println("\n-----Menu quản lí-----");
            System.out.println("1.Danh sách khách hàng của khách sạn.");
            System.out.println("2.Thêm mới khách hàng.");
            System.out.println("3.Xóa khách hàng.");
            System.out.println("4.Tìm kiếm theo tên.");
            System.out.println("5.Thoát");
            System.out.print("Lựa chọn:>");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    ArrayList<Customer> list= customerController.getList();
                    System.out.println("\n-----Danh sách khách hàng-----");
                    for (Customer cus : list){
                        System.out.println(cus);
                    }
                    break;
                case 2:
                    Customer newCustomer = addInfor();
                    customerController.addCustomer(newCustomer);
                    System.out.println("Thêm mới thành công!!!");

                    break;
                case 3:
                    System.out.println("\n-----Xóa khách hàng-----");
                    System.out.print("Nhập ID khách hàng: ");
                    String target = sc.nextLine();
                    if(customerController.deleteCustomer(target)){
                        System.out.println("Xóa thành công!!!");
                    }
                    else{
                        System.out.println("ID không có trong danh sách,vui lòng thử lại!!!");
                    }
                    break;
                case 4:
                    System.out.println("-----Tìm kiếm khách hàng-----");
                    System.out.print("Nhập tên khách hàng muốn tìm: ");
                    String name =sc.nextLine();
                    ArrayList<Customer> result=customerController.findCustomerByName(name);
                    if(result.isEmpty()){
                        System.out.println("Không có khách hàng tên "+name+" trong danh sách.");
                    }
                    else{
                        for (Customer cus: result){
                            System.out.println(cus);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Trở lại menu chính!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ,thử lại! ");
            }
        }

    }
    public  void mainMenuNhaHang(){
        while (true){
            System.out.println("\n-----Menu quản lí-----");
            System.out.println("1.Danh sách khách hàng của khách sạn.");
            System.out.println("2.Thêm mới khách hàng.");
            System.out.println("3.Xóa khách hàng.");
            System.out.println("4.Tìm kiếm theo tên.");
            System.out.println("5.Thoát");
            System.out.print("Lựa chọn:>");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    ArrayList<Customer> list= customerController.getList();
                    System.out.println("\n-----Danh sách khách hàng-----");
                    for (Customer cus : list){
                        System.out.println(cus);
                    }
                    break;
                case 2:
                    Customer newCustomer = addInfor();
                    customerController.addCustomer(newCustomer);
                    System.out.println("Thêm mới thành công!!!");

                    break;
                case 3:
                    System.out.println("\n-----Xóa khách hàng-----");
                    System.out.print("Nhập ID khách hàng: ");
                    String target = sc.nextLine();
                    if(customerController.deleteCustomer(target)){
                        System.out.println("Xóa thành công!!!");
                    }
                    else{
                        System.out.println("ID không có trong danh sách,vui lòng thử lại!!!");
                    }
                    break;
                case 4:
                    System.out.println("-----Tìm kiếm khách hàng-----");
                    System.out.print("Nhập tên khách hàng muốn tìm: ");
                    String name =sc.nextLine();
                    ArrayList<Customer> result=customerController.findCustomerByName(name);
                    if(result.isEmpty()){
                        System.out.println("Không có khách hàng tên "+name+" trong danh sách.");
                    }
                    else{
                        for (Customer cus: result){
                            System.out.println(cus);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Trở lại menu chính!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ,thử lại! ");
            }
        }

    }
    public  void mainMenuThuVien(){
        while (true){
            System.out.println("\n-----Menu quản lí-----");
            System.out.println("1.Danh sách khách hàng của khách sạn.");
            System.out.println("2.Thêm mới khách hàng.");
            System.out.println("3.Xóa khách hàng.");
            System.out.println("4.Tìm kiếm theo tên.");
            System.out.println("5.Thoát");
            System.out.print("Lựa chọn:>");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    ArrayList<Customer> list= customerController.getList();
                    System.out.println("\n-----Danh sách khách hàng-----");
                    for (Customer cus : list){
                        System.out.println(cus);
                    }
                    break;
                case 2:
                    Customer newCustomer = addInfor();
                    customerController.addCustomer(newCustomer);
                    System.out.println("Thêm mới thành công!!!");

                    break;
                case 3:
                    System.out.println("\n-----Xóa khách hàng-----");
                    System.out.print("Nhập ID khách hàng: ");
                    String target = sc.nextLine();
                    if(customerController.deleteCustomer(target)){
                        System.out.println("Xóa thành công!!!");
                    }
                    else{
                        System.out.println("ID không có trong danh sách,vui lòng thử lại!!!");
                    }
                    break;
                case 4:
                    System.out.println("-----Tìm kiếm khách hàng-----");
                    System.out.print("Nhập tên khách hàng muốn tìm: ");
                    String name =sc.nextLine();
                    ArrayList<Customer> result=customerController.findCustomerByName(name);
                    if(result.isEmpty()){
                        System.out.println("Không có khách hàng tên "+name+" trong danh sách.");
                    }
                    else{
                        for (Customer cus: result){
                            System.out.println(cus);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Trở lại menu chính!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ,thử lại! ");
            }
        }

    }
    public Customer addInfor(){
        System.out.println("\n-----Thêm thông tin khách hàng-----");
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập Ngày tháng năm sinh(yyyy-mm-dd): ");
        String temp = sc.nextLine();
        LocalDate dob = LocalDate.parse(temp, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.print("Nhập địa chỉ: ");
        String address = sc.nextLine();
        return new Customer(address,dob,name,id);
    }
}
