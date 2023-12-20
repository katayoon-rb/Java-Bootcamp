import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        char[] test = scanner.next().toCharArray();
        char[] answer = scanner.next().toCharArray();
        int score = 0;

        for (int i = 0; i < num; i++) {
            if (test[i] != answer[i]) { score++; }
        }

        System.out.println(score);
    }
}