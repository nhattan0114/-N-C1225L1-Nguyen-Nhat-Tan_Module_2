package ss1_introduction_to_Java;

import java.util.Scanner;

public class UngDungChuyenDoiTIenTe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double usdt;
        double rate;
        boolean isContinue= true;
        do {

            System.out.print("Enter amount of usdt: ");
            usdt = Double.parseDouble(sc.nextLine());
            System.out.print("Enter rate: ");
            rate =Double.parseDouble(sc.nextLine());
            double result= usdt * rate;
            System.out.println("Total: "+result);
            System.out.print("Do you want to continue(Y/N): ");
            String confirm=sc.nextLine();
            if (confirm.equalsIgnoreCase("N")){
                isContinue=false;
            }

        }while(isContinue);






    }
}
