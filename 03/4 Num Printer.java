import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        String[] inpArr = inp.split("");


        for (int i = 0; i < inpArr.length; i++) {
            int num = 0;
            for (int j = 0; j < Integer.parseInt(inpArr[i]); j++) {
                num += Integer.parseInt(inpArr[i]) * (int)Math.pow(10, j);
            }

            if (num == 0) { System.out.println(inpArr[i] + ": "); }
            else { System.out.println(inpArr[i] + ": " + num); }
        }
    }
}