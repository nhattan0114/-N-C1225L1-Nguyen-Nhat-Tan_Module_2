package casestudy.view;

import casestudy.controller.PatientController;
import casestudy.entity.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class PatientView  {
    PatientController patientController = new PatientController();
    public static Scanner sc = new Scanner(System.in);
    public static final String PHONE_REGEX="^(\\+84|84|0)(3[2-9]|5[689]|7[06-9]|8[0-689]|9[0-46-9])\\d{7}$";


    public void run(){
        int choice;
        while (true){
            System.out.println("=========Quản lí bệnh nhân=========");
            System.out.println("1.Hiện thị danh sách bệnh nhân.");
            System.out.println("2.Thêm bệnh nhân.");
            System.out.println("3.Xóa bệnh nhân.");
            System.out.println("4.Cập nhật thông tin bệnh nhân.");
            System.out.println("5.Tìm kiếm bệnh nhân.");
            System.out.println("6.Sắp xếp bệnh nhân.");
            System.out.println("7.Quay lại menu.");
            choice=inputInterger("Lựa chọn");
            switch (choice){
                case 1:
                    showPatient();
                    break;
                case 2:
                    addPatient();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    updatePatient();
                    break;
                case 5:
                    findPatient();
                    break;
                case 6:
                    sortPatient();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Vui lòng nhập lại!");
            }
        }
    }


    public void showPatient() {
        displayDoctor(patientController.getList());
    }

    public void displayDoctor(List<Patient> patientList) {
        if (patientList.isEmpty()){
            System.out.println("===Không tồn tại===");
            return;
        }
        System.out.println("+----------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-5s | %-25s | %-20s | %-20s | %-20s | %-10s | %-15s |\n",
                "ID", "Tên bệnh nhân", "Ngày tháng năm sinh","Ngày nhập viện","Số điện thoại","Địa chỉ","Bệnh");
        System.out.println("+----------------------------------------------------------------------------------------------------------------+");
        for (Patient patient : patientList){
            System.out.println(patient);
        }
        System.out.println("+----------------------------------------------------------------------------------------------------------------+");
    }


    public void sortPatient() {
        System.out.println("1.Sắp xếp theo ID.");
        System.out.println("2.Sắp xếp theo tên.");
        System.out.println("3.Sắp xếp theo khoa.");
        int choice =inputInterger("Lựa chọn");
        switch (choice){
            case 1:
                if (patientController.sortByID()){
                    System.out.println("===Sắp xếp thành công!===");
                    displayDoctor(patientController.getList());
                }else {
                    System.out.println("===Sắp xếp thất bại!===");
                }
                break;
            case 2:
                if (patientController.sortByName()){
                    System.out.println("===Sắp xếp thành công!===");
                    displayDoctor(patientController.getList());
                }else {
                    System.out.println("===Sắp xếp thất bại!===");
                }
                break;
            case 3:
                if (patientController.sortByHospitalDepartment()){
                    System.out.println("===Sắp xếp thành công!===");
                    displayDoctor(patientController.getList());
                }else {
                    System.out.println("===Sắp xếp thất bại!===");
                }
                break;
            default:
                System.out.println("===Vui lòng thử lại!===");
        }


    }

    public void findPatient() {
        System.out.println("1.Tìm theo ID.");
        System.out.println("2.Tìm theo tên.");
        System.out.println("3.Tìm theo khoa.");
        int choice =inputInterger("Lựa chọn");
        switch (choice){
            case 1:
                System.out.print("Nhập ID muốn tìm: ");
                String id=sc.nextLine();
                List<Patient> result=patientController.searchByID(id);
                displayDoctor(result);
                break;
            case 2:
                System.out.print("Nhập tên muốn tìm: ");
                String name=sc.nextLine();
                List<Patient> result2=patientController.searchByName(name);
                displayDoctor(result2);
                break;
            case 3:
                System.out.print("Nhập khoa muốn tìm: ");
                String department=sc.nextLine();
                List<Patient> result3=patientController.searchByHospitalDepartment(department);
                displayDoctor(result3);
                break;
            default:
                System.out.println("===Vui lòng thử lại!===");
        }

    }

    public void updatePatient() {
        System.out.print("Nhập ID bệnh nhân muốn cập nhật: ");
        String updateID=sc.nextLine();
        System.out.println("=====Cập nhật thông tin===== ");
        Patient newPatient=inputPatient();
        if(patientController.update(updateID,newPatient)){
            System.out.println("===Cập nhật thành công!===");
        }else {
            System.out.println("===Cập nhật thất bại!===");
        }
    }

    public void deletePatient() {
        System.out.print("Nhập ID bệnh nhân muốn xóa: ");
        String deleteID=sc.nextLine();
        if (patientController.delete(deleteID)){
            System.out.println("===Xoá thành công!===");
        }else {
            System.out.println("===Xóa thất bại!===");
        }

    }

    public void addPatient() {
        Patient patient=inputPatient();
        if (patientController.add(patient)){
            System.out.println("===Thêm mới thành công!===");
        }else {
            System.out.println("===Thêm mới thất bại!===");
        }
    }

    public Patient inputPatient(){
        System.out.print("Nhập ID bệnh nhân: ");
        String id=sc.nextLine();
        System.out.print("Nhập tên bệnh nhân: ");
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
        LocalDate admissionDate;
        while (true){
            try {
                System.out.print("Nhập ngày nhập viện (dd-MM-yyyy): ");
                String date=sc.nextLine();
                admissionDate=LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
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
        System.out.print("Nhập bệnh: ");
        String disease=sc.nextLine();
        return new Patient(id,dob,name,admissionDate,add,phone,disease);
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
