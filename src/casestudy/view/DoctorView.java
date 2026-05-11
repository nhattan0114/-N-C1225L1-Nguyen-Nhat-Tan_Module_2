package casestudy.view;

import casestudy.controller.DoctorController;
import casestudy.entity.Doctor;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class DoctorView {
    DoctorController doctorController = new DoctorController();
    public static Scanner sc = new Scanner(System.in);
    public static final String PHONE_REGEX="^(\\+84|84|0)(3[2-9]|5[689]|7[06-9]|8[0-689]|9[0-46-9])\\d{7}$";


    public void run(){
        int choice;
        while (true){
            System.out.println("=========Quản lí bác sĩ=========");
            System.out.println("1.Hiện thị danh sách bác sĩ.");
            System.out.println("2.Thêm bác sĩ.");
            System.out.println("3.Xóa bác sĩ.");
            System.out.println("4.Cập nhật thông tin bác sĩ.");
            System.out.println("5.Tìm kiếm bác sĩ.");
            System.out.println("6.Sắp xếp bác sĩ.");
            System.out.println("7.Quay lại menu.");
            choice=inputInterger("Lựa chọn");
            switch (choice){
                case 1:
                    showDoctor();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    updateDoctor();
                    break;
                case 5:
                    findDoctor();
                    break;
                case 6:
                    sortDoctor();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Vui lòng nhập lại!");
            }
        }
    }


    public void showDoctor() {
        displayDoctor(doctorController.getList());
    }

    public void displayDoctor(List<Doctor> doctorList) {
        if (doctorList.isEmpty()){
            System.out.println("===Không tồn tại===");
            return;
        }
        System.out.println("+----------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-5s | %-25s | %-20s | %-10s | %-20s | %-15s |\n",
                "ID", "Tên bác sĩ", "Ngày tháng năm sinh","Địa chỉ","Số điện thoại","Khoa");
        System.out.println("+----------------------------------------------------------------------------------------------------------------+");
        for (Doctor doctor : doctorList){
            System.out.println(doctor);
        }
        System.out.println("+----------------------------------------------------------------------------------------------------------------+");
    }


    public void sortDoctor() {
        System.out.println("1.Sắp xếp theo ID.");
        System.out.println("2.Sắp xếp theo tên.");
        System.out.println("3.Sắp xếp theo khoa.");
        int choice =inputInterger("Lựa chọn");
        switch (choice){
            case 1:
                if (doctorController.sortByID()){
                    System.out.println("===Sắp xếp thành công!===");
                    displayDoctor(doctorController.getList());
                }else {
                    System.out.println("===Sắp xếp thất bại!===");
                }
                break;
            case 2:
                if (doctorController.sortByName()){
                    System.out.println("===Sắp xếp thành công!===");
                    displayDoctor(doctorController.getList());
                }else {
                    System.out.println("===Sắp xếp thất bại!===");
                }
                break;
            case 3:
                if (doctorController.sortByHospitalDepartment()){
                    System.out.println("===Sắp xếp thành công!===");
                    displayDoctor(doctorController.getList());
                }else {
                    System.out.println("===Sắp xếp thất bại!===");
                }
                break;
            default:
                System.out.println("===Vui lòng thử lại!===");
        }


    }

    public void findDoctor() {
        System.out.println("1.Tìm theo ID.");
        System.out.println("2.Tìm theo tên.");
        System.out.println("3.Tìm theo khoa.");
        int choice =inputInterger("Lựa chọn");
        switch (choice){
            case 1:
                System.out.print("Nhập ID muốn tìm: ");
                String id=sc.nextLine();
                List<Doctor> result=doctorController.searchByID(id);
                displayDoctor(result);
                break;
            case 2:
                System.out.print("Nhập tên muốn tìm: ");
                String name=sc.nextLine();
                List<Doctor> result2=doctorController.searchByName(name);
                displayDoctor(result2);
                break;
            case 3:
                System.out.print("Nhập khoa muốn tìm: ");
                String department=sc.nextLine();
                List<Doctor> result3=doctorController.searchByHospitalDepartment(department);
                displayDoctor(result3);
                break;
            default:
                System.out.println("===Vui lòng thử lại!===");
        }

    }

    public void updateDoctor() {
        System.out.print("Nhập ID bác sĩ muốn cập nhật: ");
        String updateID=sc.nextLine();
        System.out.println("=====Cập nhật thông tin===== ");
        Doctor newDoctor=inputDoctor();
        if(doctorController.update(updateID,newDoctor)){
            System.out.println("===Cập nhật thành công!===");
        }else {
            System.out.println("===Cập nhật thất bại!===");
        }
    }

    public void deleteDoctor() {
        System.out.print("Nhập ID bác sĩ muốn xóa: ");
        String deleteID=sc.nextLine();
        if (doctorController.delete(deleteID)){
            System.out.println("===Xoá thành công!===");
        }else {
            System.out.println("===Xóa thất bại!===");
        }

    }

    public void addDoctor() {
        Doctor doctor=inputDoctor();
        if (doctorController.add(doctor)){
            System.out.println("===Thêm mới thành công!===");
        }else {
            System.out.println("===Thêm mới thất bại!===");
        }
    }

    public Doctor inputDoctor(){
        System.out.print("Nhập ID bác sĩ: ");
        String id=sc.nextLine();
        System.out.print("Nhập tên bác sĩ: ");
        String name=sc.nextLine();
        LocalDate dob;
        while (true){
            try {
                System.out.print("Nhập ngày-tháng-năm sinh(dd-MM-yyyy): ");
                String date=sc.nextLine();
                dob=LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                break;
            }catch (DateTimeParseException e){
                System.out.println("Nhập theo format dd-MM-yyyy!");
            }
        }
        System.out.print("Nhập địa chỉ: ");
        String add=sc.nextLine();
        String phone;
        do {
            System.out.print("Nhập số điện thoại: ");
            phone=sc.nextLine();
            if (!phone.matches(PHONE_REGEX)){
                System.out.println("Vui lòng nhập lại (sdt gồm 10 số,bắt đầu với 0/84/+84)");
            }
        }while (!phone.matches(PHONE_REGEX));
        System.out.print("Nhập khoa: ");
        String department=sc.nextLine();
        return new Doctor(name,dob,add,phone,id,department);
    }

    public  int inputInterger(String mes){
        while (true){
            try{
                System.out.print(mes+": ");
                return Integer.parseInt(sc.nextLine());

            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số!");
            }
        }

    }
}
