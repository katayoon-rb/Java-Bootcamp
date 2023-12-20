import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sins = {"sonbol", "samanoo", "sekke", "sabze", "serke", "sib", "sir"};
        int num = scanner.nextInt();

        for (int s = 1; s <= num; s++) {
            System.out.println( sins[s - 1] );
        }
    }
}