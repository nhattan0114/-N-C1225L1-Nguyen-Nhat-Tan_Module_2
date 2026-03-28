package Method;

import java.util.Scanner;

public class DemSoLanXuatHien {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String input;
        System.out.print("Nhập chuỗi: ");
        input=sc.nextLine();
        String c;
        System.out.print("Nhập kí tự muốn đếm: ");
        c=sc.nextLine();
        System.out.println("Kí tự "+c+" xuất hiện: "+Count(input,c)+" lần.");

    }

    public static int Count(String ipt,String kt){
        int count =0;
        char target=kt.toLowerCase().charAt(0);
        for (int i = 0; i <ipt.length() ; i++) {
            if ((Character.toLowerCase(ipt.charAt(i))==target)){
                count++;
            }
        }
        return count;
    }
}
