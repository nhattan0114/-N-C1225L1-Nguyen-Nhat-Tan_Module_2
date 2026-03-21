package Mang;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int[] numbers={2,2,5,1,7,1,9,10};
        System.out.println(Arrays.toString(numbers));
        System.out.print("Nhập phần từ muốn thêm: ");
        int x = sc.nextInt();
        System.out.print("Nhập vị trí (index): ");
        int index_add= sc.nextInt();
        int size= numbers.length;
        if (index_add<=-1||index_add>size){
            System.out.println("Không chèn dc phần tử vào mảng!");
            return;
        }
        int[] newArr=new int[size+1];
            for(int i = 0; i < index_add; i++) {
                newArr[i]=numbers[i];
            }

            newArr[index_add]=x;

            for (int i = index_add; i < size; i++) {
                newArr[i+1] =numbers[i];
            }


        System.out.println("Mảng sau khi chèn: ");
        System.out.println(Arrays.toString(newArr));
    }
}
