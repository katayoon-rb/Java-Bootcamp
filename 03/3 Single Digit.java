import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();

        while (num >= 10) {
            String[] numArr = Long.toString(num).split("");
            num = 0;

            for (int i = 0; i < numArr.length; i++) {
                num += Long.parseLong(numArr[i]);
            }
        }

        System.out.println(num);
    }
}