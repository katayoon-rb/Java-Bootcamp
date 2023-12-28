import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {
    static boolean isPrime(int n) {
        if (n <= 1) { return false; }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) { return false; }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int[] nums = new int[end - start - 1];
        int j = 0;

        for (int i = start + 1; i < end; i++) {
            if (isPrime(i)) {
                nums[j] = i;
                j++;
            }
        }
        nums = Arrays.stream(nums).filter(x -> x != 0).toArray();

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(',');
            }
        }

    }
}
