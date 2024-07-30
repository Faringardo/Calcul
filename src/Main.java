import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        int a = 0;
        int b = 0;
        int result = 0;
        boolean isRoman = false;

        String[] numbers = inputString.split(" ");
        char operator = numbers[1].charAt(0);

        if ((numbers[0].matches("^\\d+$") && numbers[2].matches("^\\d+$"))){
            a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[2]);
        }else if (!(numbers[0].matches("^\\d+$") && numbers[2].matches("^\\d+$"))){
            a = Roma.romanToArabic(numbers[0]);
            b = Roma.romanToArabic(numbers[2]);
            isRoman = true;
        }else {
            System.out.println("Invalid input number only arabic or roman");
        }

        if ((isRoman == false) && (!((a >= 1 && a <= 10) && (b >= 1 && b <= 10)))){
            throw new Exception("Invalid input number");
        }

        result = doMathOperation(a, b, operator);

        if (isRoman == false){
            System.out.println(result);
        }else{
            System.out.println(Roma.arabicToRoman(result));
        }
    }

    public static int doMathOperation(int var1, int var2, char operator) throws Exception {
        switch (operator) {
            case '+':
                return var1 + var2;
            case '-':
                return var1 - var2;
            case '*':
                return var1 * var2;
            case '/':
                return var1 / var2;
            default:
                throw new Exception("Invalid operator");
        }
    }
}