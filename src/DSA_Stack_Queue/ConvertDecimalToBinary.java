package DSA_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int input= Integer.parseInt(sc.nextLine());
        while(input!=0){
            stack.push(input%2);
            input=input/2;
        }
        System.out.println("Binary: ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
