package searchalgorithm;

import java.util.Scanner;

public class CalculateTheComplexityOfTheAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();
        int[] frequentChar = new int[255];
        for (int i = 0; i < input.length(); i++) {
            int ascii = input.charAt(i);
            frequentChar[ascii] += 1;
        }
        int max = 0;
        char character = (char) 255;
        for (int j = 0; j < 255; j++) {
            if (frequentChar[j] > max) {
                max = frequentChar[j];
                character = (char) j;
            }
        }
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
    }

