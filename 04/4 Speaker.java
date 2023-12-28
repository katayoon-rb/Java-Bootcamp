import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split("");

        for (int i = 0; i < inputArr.length; i++) {
            for (int j = 0; j < i; j++) {
                inputArr[j] = inputArr[i];
            }
            System.out.println(String.join("", inputArr));
        }
    }
}
