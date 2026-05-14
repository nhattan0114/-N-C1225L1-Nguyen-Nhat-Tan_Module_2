package casestudy;

import casestudy.view.DoctorView;
import casestudy.view.PatientView;


public class Main {
    public static void main(String[] args) {
        PatientView patientView = new PatientView();
        DoctorView doctorView = new DoctorView();
        int choice;
        while (true){
            System.out.println("\n==========Xin chào==========");
            System.out.println("======Quản lí bệnh viện======");
            System.out.println("1.Quản lí bác sĩ.");
            System.out.println("2.Quản lí bệnh nhân.");
            System.out.println("3.Thoát.");
            choice =doctorView.inputInterger("Lựa chọn");
            switch (choice){
                case 1:
                    doctorView.run();
                    break;
                case 2:
                    patientView.run();
                    break;
                case  3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sai cú pháp vui lòng thử lại!");
            }
        }
    }


}
