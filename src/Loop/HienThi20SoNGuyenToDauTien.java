package Loop;

import java.util.Scanner;

public class HienThi20SoNGuyenToDauTien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count =0;
        System.out.print("Nhập số lượng số nguyên tố cần in: ");
        int num=sc.nextInt();

        int N=2;
        while (count<num){
            boolean isPrime =true;
            for (int i = 2; i <=Math.sqrt(N) ; i++) {
                    if (N%i==0){
                        isPrime=false;
                        break;
                    }
            }
            if (isPrime){
                System.out.println(N+ " ");
                count++;
            }
          N++;
        }
    }
}
