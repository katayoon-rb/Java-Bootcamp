import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();
        int ans = 0;
        int i = num1Arr.length - 1;

        if (num1Arr[i] > num2Arr[i]) { ans = 1; }
        else if (num1Arr[i] < num2Arr[i]) { ans = 2; }

        while (num1Arr[i] == num2Arr[i]) {
            if (i == 0) {
                ans = 0;
                break;
            }
            i--;
        }

        if (ans == 1) { System.out.println(num2 + " < " + num1); }
        else if (ans == 2) { System.out.println(num1 + " > " + num2); }
        else { System.out.println(num1 + " = " + num2); }
    }
}
