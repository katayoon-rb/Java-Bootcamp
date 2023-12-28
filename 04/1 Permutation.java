import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line1 = sortString(scanner.nextLine());
        String line2 = sortString(scanner.nextLine());

        if (line1.equals(line2)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
