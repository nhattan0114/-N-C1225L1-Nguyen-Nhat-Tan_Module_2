package Mang;

import java.util.Arrays;
import java.util.Scanner;

public class TimMinTrongMang {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int[] arr = new int[5];
        Add(arr);
        Display(arr);
        System.out.println("Min trong mảng: "+FindMin(arr));
    }


    public static void Add(int[] arr){
            for (int j = 0; j < arr.length; j++) {
                System.out.print("Nhập ["+(j+1)+"]: ");
                arr[j]=sc.nextInt();
            }
        }



    public static void Display(int[]arr){
        System.out.println(Arrays.toString(arr));
        }


    public static int FindMin(int[]arr){
        int min=arr[0];
        for (int j : arr) {
            if (min > j) {
                min = j;
            }
        }
        return min;
    }
}
