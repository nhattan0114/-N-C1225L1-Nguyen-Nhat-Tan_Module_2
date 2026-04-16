package DSA_Stack_Queue;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Reverse_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Stack: Vao truoc ra sau
        //push():Them phan tu vao  stack
        //pop():Lay va xoa phan tu
        //peek():Xem phan tu nhung ko xoa
        //search():Tim vi tri
        int[] arr = {1,2,3,4,5};
        System.out.println("Mang ban dau: "+ Arrays.toString(arr));
        reverseInt(arr);
        System.out.println("Mang sau khi dao: "+Arrays.toString(arr));

        System.out.println("---------------");
        System.out.println("Dao chuoi bang Stack");
        System.out.print("Nhap chuoi: ");
        String input=sc.nextLine();
        System.out.println("Chuoi ban dau: "+input);
        String[] result=reverseString(input);
        System.out.println("Chuoi sau khi dao: ");
        for (String s : result) {
            System.out.print(s + " , ");
        }
    }
    public static void reverseInt(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for (int j : arr) {
            stack.push(j);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i]=stack.pop();
        }
    }

    public static String[] reverseString(String chuoi){

        Stack<String> stack = new Stack<>();

        String[] tachChuoi=chuoi.split("\\s+");

        for (String tach_Chuoi: tachChuoi){
            stack.push(tach_Chuoi);
        }

        String[] ketQua= new String[tachChuoi.length];
        for (int i = 0; i < tachChuoi.length ; i++) {
                ketQua[i]=stack.pop();
        }

        return ketQua;
    }
}
