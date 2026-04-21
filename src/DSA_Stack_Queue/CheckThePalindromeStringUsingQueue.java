package DSA_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckThePalindromeStringUsingQueue {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        String input = "Able was I ere I was Able";
        String[] words=input.split("\\s+");

        for (String word:words){
            stack.push(word);
            queue.add(word);
        }
        boolean isPalindrome=true;
        while (!stack.isEmpty() && !queue.isEmpty()){
            if (!stack.pop().equals(queue.poll())){
                isPalindrome=false;
                break;
            }
        }
        System.out.println("Input is Palindrome: "+isPalindrome);
    }
}