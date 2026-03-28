package Method;


import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

public class TongCacSoOMotCotXacDinh {
    public static Scanner sc = new Scanner(in);
    public static Random rand = new Random();
    public static void main(String[] args) {

        int[][] arr = new int[4][4];
        Add(arr);
        Display(arr);
        int choice;
        out.print("Chọn cột muốn tính tổng: ");
        choice =sc.nextInt();
        out.println("Tổng các số ở cột "+choice+":"+CalculateSum(choice,arr));

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

    public static int CalculateSum(int choice,int[][]arr){
        int sum=0;
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (j == choice-1) {
                    sum += ints[j];
                }
            }
        }
        return sum;
    }
}
