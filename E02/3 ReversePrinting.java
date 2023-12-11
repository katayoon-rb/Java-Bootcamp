import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        String numStr = "";

        do {
            num = scanner.nextInt();
            if (num != 0) {
                numStr += num + " ";
            }
        } while (num != 0);


        String[] numbers = numStr.split(" ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(Integer.parseInt( numbers[ (numbers.length - 1) - i ] ));
        }
    }
}