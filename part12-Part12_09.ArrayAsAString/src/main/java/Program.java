
public class Program {

    public static void main(String[] args) {
        // Test your method here
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int[] is : array) {
            for (int j = 0; j < is.length; j++) {
                int k = is[j];
                sb.append(k);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
