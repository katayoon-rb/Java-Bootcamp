import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = { scanner.nextInt(), scanner.nextInt(), scanner.nextInt() };
        Arrays.sort(numbers);

        if ( Math.pow(numbers[2], 2) == Math.pow(numbers[0], 2) + Math.pow(numbers[1], 2) ) {
            System.out.println("YES");
        }
        else { System.out.println("NO"); }
    }
}