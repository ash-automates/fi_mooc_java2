package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndLabelApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Button button = new Button("This is a button!");
        Label text = new Label("This is some text");
        
        FlowPane componentsGroup = new FlowPane();
        componentsGroup.getChildren().add(text);
        componentsGroup.getChildren().add(button);
        
        Scene scene = new Scene(componentsGroup);
        window.setScene(scene);
        window.show();
    }

}
