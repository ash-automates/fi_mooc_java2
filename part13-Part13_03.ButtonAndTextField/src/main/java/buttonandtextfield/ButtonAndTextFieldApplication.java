package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Button button = new Button("This is a button!");
        TextField text = new TextField("This is some text");
        
        FlowPane componentsGroup = new FlowPane();
        componentsGroup.getChildren().add(button);
        componentsGroup.getChildren().add(text);
        
        Scene scene = new Scene(componentsGroup);
        window.setScene(scene);
        window.show();
    }
}
