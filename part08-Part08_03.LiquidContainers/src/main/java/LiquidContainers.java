
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstVolume = 0;
        int secondVolume = 0;
        int maxVolume = 100;

        while (true) {
            String input = scan.nextLine();
            if (input.equals("quit")) {
                System.out.println("First: " + firstVolume + "/100");
                System.out.println("Second: " + secondVolume + "/100");
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            System.out.println("First: " + firstVolume + "/" + maxVolume);
            System.out.println("Second: " + secondVolume + "/" + maxVolume);
            if (command.equals("add")) {
                if (amount > 0) {
                    firstVolume = firstVolume + amount <= 100 ? firstVolume + amount : 100;
                }
            }
            if (command.equals("move")) {
                if (amount > 0) {
                    amount = secondVolume + amount > 100 ? 100 - secondVolume : amount;
                    if (amount <= firstVolume) {
                        secondVolume = secondVolume + amount;
                        firstVolume = firstVolume - amount;
                    } else {
                        secondVolume = secondVolume + firstVolume;
                        firstVolume = 0;
                    }
                }
            }
            if (command.equals("remove")) {
                if (amount > 0) {
                    secondVolume = secondVolume - amount >= 0 ? secondVolume - amount : 0;
                }
            }
        }
    }

}
