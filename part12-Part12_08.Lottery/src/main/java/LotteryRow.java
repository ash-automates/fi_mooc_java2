
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        Random rand = new Random();
        // the method containsNumber is probably useful
        for (int i = 0; i < 7; i++) {
            while (true) {
                int pick = rand.nextInt(40) + 1;
                if (!this.containsNumber(pick)) {
                    this.numbers.add(pick);
                    break;
                }
            }
        }
    }

    public boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }
}

