
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static double main(String[] args) {
        ArrayList<String> rows = new ArrayList<>();
        ArrayList<LiteracyStat> stats = new ArrayList<>();
        try {
            Files.lines(Paths.get("literacy.csv")).forEach(row -> rows.add(row));
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        for (String row : rows) {
            String[] parts = row.split(",");
            boolean gender = parts[2].contains("female");
            String country = parts[3];
            String year = parts[4];
            double stat = Double.valueOf(parts[5]);
            stats.add(new LiteracyStat(country, year, gender, stat));
        }
        stats.stream().sorted((v1, v2) -> {
            if (v1.getStat() < v2.getStat()) {
                return -1;
            } else if (v1.getStat() > v2.getStat()) {
                return 1;
            } else {
                return 0;
            }
        }).forEach(stat -> System.out.println(stat));
        return 0;
    }
}
