package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane firstLayout = new BorderPane();
        firstLayout.setTop(new Label("First view!"));
        Button firstButton = new Button("To the second view!");
        firstLayout.setCenter(firstButton);
        Scene firstScene = new Scene(firstLayout);
        
        Button secondButton = new Button("To the third view!");        
        VBox secondLayout = new VBox(secondButton, new Label("Second view!"));
        Scene secondScene = new Scene(secondLayout);
        
        GridPane thirdLayout = new GridPane();
        thirdLayout.add(new Label("Third view!"), 0, 0);
        Button thirdButton = new Button("To the first view!");
        thirdLayout.add(thirdButton, 1, 1);
        Scene thirdScene = new Scene(thirdLayout);
        
        firstButton.setOnAction((event) -> {
            window.setScene(secondScene);
            window.show();
        });
        
        secondButton.setOnAction((event) -> {
            window.setScene(thirdScene);
            window.show();
        });
        
        thirdButton.setOnAction((event) -> {
            window.setScene(firstScene);
            window.show();
        });
        
        window.setScene(firstScene);
        window.show();
    }

}
