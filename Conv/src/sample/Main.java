package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Подключаем fxml файл
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Конвертер валют");
        primaryStage.setScene(new Scene(root, 365, 314));
        // Запрещаем изменять размер окна
        primaryStage.setResizable(false);
        // открывем окно
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
