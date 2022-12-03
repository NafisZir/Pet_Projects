package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();

        primaryStage.setTitle("Sapper");
        primaryStage.setScene(new Scene(root, 250, 348));

        primaryStage.setResizable(false);
        primaryStage.show();

        // Отлавливаем нажатие мыши
        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.SECONDARY)){
                    controller.mouseEventRight((int) event.getSceneX(), (int) event.getSceneY());
                }
                else {
                    controller.mouseEventLeft((int) event.getSceneX(), (int) event.getSceneY());
                }
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
