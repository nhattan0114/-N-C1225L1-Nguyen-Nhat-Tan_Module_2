package ss1_introduction_to_Java;
import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (0 - 999): ");
        int number = scanner.nextInt();

        if (number < 0 || number >= 1000) {
            System.out.println("out of ability");
        } else {
            System.out.println(readNumber(number));
        }
    }



public static String readNumber(int n) {
    if (n < 10) return readOnes(n);
    if (n < 20) return readTeens(n);
    if (n < 100) { // Bước 4
        int tens = n / 10;
        int ones = n % 10;
        return readTens(tens) + (ones != 0 ? " " + readOnes(ones) : "");
    }
    int hundreds = n / 100;
    int remainder = n % 100;
    String result = readOnes(hundreds) + " hundred";
    if (remainder != 0) {
        result += " and " + readNumber(remainder);
    }
    return result;
}

public static String readOnes(int n) {
    switch (n) {
        case 0: return "zero";
        case 1: return "one";
        case 2: return "two";
        case 3: return "three";
        case 4: return "four";
        case 5: return "five";
        case 6: return "six";
        case 7: return "seven";
        case 8: return "eight";
        case 9: return "nine";
        default: return "";
    }
}

public static String readTeens(int n) {
    switch (n) {
        case 10: return "ten";
        case 11: return "eleven";
        case 12: return "twelve";
        case 13: return "thirteen";
        case 14: return "fourteen";
        case 15: return "fifteen";
        case 16: return "sixteen";
        case 17: return "seventeen";
        case 18: return "eighteen";
        case 19: return "nineteen";
        default: return "";
    }
}

public static String readTens(int n) {
    switch (n) {
        case 2: return "twenty";
        case 3: return "thirty";
        case 4: return "forty";
        case 5: return "fifty";
        case 6: return "sixty";
        case 7: return "seventy";
        case 8: return "eighty";
        case 9: return "ninety";
        default: return "";
    }
}
}
