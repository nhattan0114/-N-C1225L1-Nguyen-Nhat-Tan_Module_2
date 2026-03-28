package Method;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class TinhTongDgCheoChinh {
    public static final Random rand = new Random();
    public static final Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        Add(arr);
        Display(arr);
        out.println("Tổng đường chéo chính của ma trận: "+Calculate(arr));



    }

    public static void Add(int[][] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]= rand.nextInt(10);
            }

        }
    }

    public static void Display(int[][]arr){
        out.println("Mang: ");
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                out.print(ints[j] + " ");
            }
            out.println();
        }
    }
    public static int Calculate(int[][] arr){
        int sum=0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i==j){
                    sum+=arr[i][i];
                }
            }
        }
        return  sum;
    }
    }

