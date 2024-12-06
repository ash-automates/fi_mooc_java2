
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        double average;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        // toteuta ohjelmasi tänne
        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            inputs.add(input);
        }
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String flag = scanner.nextLine();
        if (flag.equals("n")) {
            average = inputs.stream().mapToInt(v -> Integer.valueOf(v)).filter(v -> v < 0).average().getAsDouble();
        } else {
            average = inputs.stream().mapToInt(v -> Integer.valueOf(v)).filter(v -> v > 0).average().getAsDouble();
        }        
        System.out.println(average);
    }
}
