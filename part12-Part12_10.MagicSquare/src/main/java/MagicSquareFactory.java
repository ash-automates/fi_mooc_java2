
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        if (size % 2 == 0) {
            return null; // only support odd sizes
        }
    
        MagicSquare square = new MagicSquare(size);
        int n = size;
        // Start at the middle of the top row: (column, row) = (n/2, 0)
        int pointerX = n / 2;
        int pointerY = 0;

        // Place all values from 1 to n*n
        for (int value = 1; value <= n * n; value++) {
            // Place the current value
            square.placeValue(pointerX, pointerY, value);

            // Compute the next candidate position: move up and to the right
            int nextX = (pointerX + 1) % n;
            int nextY = (pointerY - 1 + n) % n;

            // If the next cell is already occupied, move down (from current position)
            if (square.readValue(nextX, nextY) != 0) {
                pointerY = (pointerY + 1) % n;
                // pointerX remains unchanged
            } else {
                pointerX = nextX;
                pointerY = nextY;
            }
        }
        return square;
    }

}
