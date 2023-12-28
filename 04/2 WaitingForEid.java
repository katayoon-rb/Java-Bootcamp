import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split("/");

        int year = parseInt(inputArr[0]);
        int month = parseInt(inputArr[1]);
        int day = parseInt(inputArr[2]);

        int fullYear = 365;
        if (year % 4 == 3) {fullYear = 366;}

        int inputYear;
        if (month <= 6) { inputYear = (month - 1) * 31 + day; }
        else { inputYear = (6 * 31) + ((month - 7) * 30) + day; }

        System.out.println(fullYear - inputYear + 1);
    }
}
