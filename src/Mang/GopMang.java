package Mang;


import java.util.Arrays;
import java.util.Scanner;

public class GopMang {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int[] arr1= new int[5];
        int[] arr2= new int[5];
        System.out.println("Nhập mảng 1:");
        add(arr1);
        System.out.println("Nhập mảng 2:");
        add(arr2);

        display(arr1,1);
        display(arr2,2);

        int[] newArr=new int[10];
        merge(arr1,arr2,newArr);
        display(newArr,3);
        System.out.println("Success!!!");
    }

    public static int[] add(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print("Nhập ptu ["+(i+1)+"]:");
            arr[i]=sc.nextInt();
        }
        return arr;
    }

    public static void display(int[] arr,int num){
        System.out.println("Mảng số "+num+":");
        System.out.println(Arrays.toString(arr));
    }

    public static int[] merge(int[]arr1,int[] arr2,int[]newArr){
        for (int i = 0; i <arr1.length ; i++) {
            newArr[i]=arr1[i];
        }
        for (int j = 0; j <arr2.length ; j++) {
            newArr[j+5]=arr2[j];
        }
        return newArr;
    }
}
