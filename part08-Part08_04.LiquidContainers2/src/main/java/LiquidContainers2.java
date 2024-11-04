
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();
        
        while (true) {
            String input = scan.nextLine();
            if (input.equals("quit")) {
                System.out.println("First: " + first);
                System.out.println("Second: " + second);
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            System.out.println("First: " + first);
            System.out.println("Second: " + second);
            if (command.equals("add")) {
                first.add(amount);
            }
            if (command.equals("move")) {
                first.move(second, amount);
            }
            if (command.equals("remove")) {
                second.remove(amount);
            }
        }
    }

}
