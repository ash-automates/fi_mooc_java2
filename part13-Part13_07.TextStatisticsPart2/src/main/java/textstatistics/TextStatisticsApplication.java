package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        Label lettersCount = new Label("Letters: 0");
        Label wordsCount = new Label("Words: 0");
        Label longestWord = new Label("The longest word is:");
        HBox hbox = new HBox(lettersCount, wordsCount, longestWord);
        TextArea toAnalyze = new TextArea();
        toAnalyze.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
            lettersCount.setText("Letters: " + characters);
            wordsCount.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        });
        layout.setCenter(toAnalyze);
        layout.setBottom(hbox);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

}
