import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        int days = scanner.nextInt();
        int finalScore = 0;

        if (days == 0) { finalScore = 20; }
        else if (days == 7) { finalScore = score; }
        else { finalScore = score - days; }

        if (finalScore < 0) { finalScore = 0; }


        System.out.println(finalScore);
    }
}