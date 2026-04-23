package javacollection.view;

import javacollection.controller.ProductController;
import javacollection.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    ProductController productController = new ProductController();
    public static Scanner sc = new Scanner(System.in);
    public void run(){
        while (true){
            System.out.println("-------------------WELCOME-----------------");
            System.out.println("---------Ứng dụng quản lí sản phẩm--------- ");
            System.out.println("1.Thêm sản phẩm.");
            System.out.println("2.Xóa sản phẩm.");
            System.out.println("3.Cập nhật sản phẩm");
            System.out.println("4.Hiển thị sản phẩm");
            System.out.println("5.Tìm sản phẩm.");
            System.out.println("6.Sắp xếp sản phẩm theo giá.");
            System.out.println("7.Sắp xếp sản phẩm theo ID.");
            System.out.println("8.Thoát.");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.print("Nhập tên sản phẩm: ");
                    String name =sc.nextLine();
                    System.out.print("Nhập ID sản phẩm: ");
                    String id =sc.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double price =Double.parseDouble(sc.nextLine());
                    boolean isAdd=productController.addProduct(new Product(price,id,name));
                    if (isAdd){
                        System.out.println("\nThêm mới thành công!");
                    }else{
                        System.out.println("\nThêm mới thất bại,vui lòng thử lại!(sản phẩm không được để trống,ID không được trùng) ");
                    }

                    break;
                case 2:
                    System.out.print("Nhập ID sản phẩm muốn xóa: ");
                    String id_delete =sc.nextLine();
                    boolean isDelete=productController.deleteProduct(id_delete);
                    if (isDelete){
                        System.out.println("\nXóa thành công!");
                    }else {
                        System.out.println("\nXóa thất bại,vui lòng thử lại!(ID không có trong danh sách,ID để trống)");
                    }
                break;
                case 3:
                    System.out.print("Nhập ID muốn cập nhật: ");
                    String id_update =sc.nextLine();
                    System.out.print("Nhập ID mới: ");
                    String id_new =sc.nextLine();
                    System.out.print("Nhập tên sản phẩm mới: ");
                    String name_update =sc.nextLine();
                    System.out.print("Nhập giá mới: ");
                    double price_update =Double.parseDouble(sc.nextLine());
                    boolean isUpdate=productController.updateProduct(id_update, new Product(price_update,id_new,name_update));
                    if (isUpdate) {
                        System.out.println("\n Cập nhật thành công!");
                    }
                    else {
                        System.out.println("\n Cập nhật thất bại!");
                    }

                    break;
                case 4:
                    List<Product> result= productController.getProductList();
                    displayProduct(result);
                    break;
                case 5:
                    System.out.print("Nhập tên sản phẩm muốn tìm: ");
                    String name_search =sc.nextLine();
                    List<Product> ketqua=productController.searchProduct(name_search);
                    displayProduct(ketqua);
                    break;
                case 6:
                    boolean isContinue=true;
                    while(isContinue){
                        System.out.print("Xếp sắp tăng dần/giảm dần(T/G): ");
                        String option =sc.nextLine();
                        switch (option.toLowerCase()){
                            case "t":
                                productController.sortProductPriceAsc();
                                displayProduct(productController.getProductList());
                                isContinue=false;
                                break;
                            case "g":
                                productController.sortProductPriceDesc();
                                displayProduct(productController.getProductList());
                                isContinue=false;
                                break;
                            default:
                                System.out.println("Thử lại!");
                        }
                    }
                    break;
                case 7:
                    productController.sortProductID();
                    displayProduct(productController.getProductList());
                    break;
                case 8:return;
                default:System.out.println("Invalid choice,try again!");
            }
        }
    }

    public static void displayProduct(List<Product> products) {
        if (products.isEmpty()){
            System.out.println("Không tồn tại");
            return;
        }
        System.out.println("+----+----------------------+------------+");
        System.out.printf("| %-2s | %-20s | %-10s |\n",
                "ID", "Tên sản phẩm", "Giá");
        System.out.println("+----+----------------------+------------+");
        for (Product product : products){
            System.out.println(product);
        }
        System.out.println("+----+----------------------+------------+");
    }

}
