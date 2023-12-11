import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dayList = { "shanbe", "1shanbe", "2shanbe", "3shanbe", "4shanbe", "5shanbe", "jome" };


        for (int k = 0; k < 3; k++) {
            scanner.nextLine();
            String[] days = scanner.nextLine().split(" ");

            for (int i = 0; i < days.length; i++) {
                for (int j = 0; j < dayList.length; j++) {
                    if (dayList[j].equals(days[i])) {
                        dayList[j] = "";
                    }
                }
            }
        }

        int available = 0;
            for (int i = 0; i < dayList.length; i++) {
                if (!dayList[i].isEmpty()) {
                    available++;
                }
            }
        System.out.println(available);
    }
}
