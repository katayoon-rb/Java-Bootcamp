import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] num = scanner.nextLine().split("");
        int len = num.length;
        boolean absurdant = false;

        for (int i = 0; i < len; i++) {
            if ( num[i].equals(num[(len - 1) - i]) ) { absurdant = true; }
            else {
                absurdant = false;
                break;
            }
        }

        if (absurdant) { System.out.println("YES"); }
        else { System.out.println("NO"); }
    }
}