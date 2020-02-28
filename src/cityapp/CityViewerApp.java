package cityapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CityViewerApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("citypanel.fxml"));
        primaryStage.setTitle("CITY CZYTACZ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
