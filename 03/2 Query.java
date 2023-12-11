import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsArr = scanner.nextLine().split(" ");
        String[] opsArr = scanner.nextLine().split(" ");


        String[] fullOp = new String[7];
        for (int i = 0; i < 4; i++) {
            fullOp[i * 2] = numsArr[i];
        }
        for (int i = 0; i < 3; i++) {
            fullOp[i * 2 + 1] = opsArr[i];
        }


        for (int j = 0; j < 6; j++) {
            if (fullOp[j].equals("*")) {
                int output = Integer.parseInt(fullOp[j - 1]) * Integer.parseInt(fullOp[j + 1]);
                fullOp[j] = "+";
                fullOp[j - 1] = "0";
                fullOp[j + 1] = Integer.toString(output);
            }
        }

        int finalOut = 0;
        for (int i = 0; i < 4; i++) {
            finalOut += Integer.parseInt(fullOp[i * 2]);
        }

        System.out.print(finalOut);
    }
}