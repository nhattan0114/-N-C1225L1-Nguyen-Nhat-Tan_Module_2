package Mang;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int[] numbers={2,2,5,1,7,1,9,10};
        System.out.println(Arrays.toString(numbers));
        System.out.print("Nhập phần từ cần xóa: ");
        int x = sc.nextInt();
        int index_del=-1;
        int size= numbers.length;
        for (int i = 0; i < size; i++) {
            if (x == numbers[i]) {
                index_del = i;
                for (int j = index_del; j < size - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                size--;
                i--;
            }
        }
        if (index_del==-1){
            System.out.println("Không tìm thấy x trong mảng");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i]+" ");
        }

        }
    }

