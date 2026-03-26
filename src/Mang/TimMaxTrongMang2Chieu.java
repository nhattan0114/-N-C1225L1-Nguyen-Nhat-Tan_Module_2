package Mang;


import java.util.Scanner;

public class TimMaxTrongMang2Chieu {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int rows;
        int cols;
        System.out.print("Nhập hàng: ");
        rows= sc.nextInt();
        System.out.print("Nhập cột: ");
        cols=sc.nextInt();
        int[][] arr = new int[rows][cols];
        Add(arr,rows,cols);
        Display(arr,rows,cols);
        System.out.println("Max trong mảng 2 chiều: "+FindMax(arr,rows,cols));
    }


    public static void Add(int[][] arr,int rows,int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Nhập ["+i+"]"+"["+j+"]: ");
                arr[i][j]=sc.nextInt();
            }
            System.out.println();
        }

    }

    public static void Display(int[][]arr,int rows,int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int FindMax(int[][]arr,int rows,int cols){
        int max=arr[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (max<arr[i][j]){
                    max =arr[i][j];
                }
            }

        }
        return max;
    }
}
