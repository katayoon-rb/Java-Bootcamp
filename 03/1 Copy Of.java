import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        String[] inpArr = inp.split(" ");

        int size = Integer.parseInt(inpArr[0]);

        String output = "";

        for (int i = 0; i <= size; i++) {
            if (i == size) { output += inpArr[1]; }
            else { output += "copy of "; }
        }

        System.out.println(output);
    }
}