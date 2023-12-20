import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] correct = {1, 1, 2, 2, 2, 8};
        int[] output = {0, 0, 0, 0, 0, 0};
        String[] answer = scanner.nextLine().split(" ");

        for (int i = 0; i < output.length; i++) {
            output[i] = correct[i] - Integer.parseInt(answer[i]);
        }

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
