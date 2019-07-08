import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));

        Parent root = (Parent) loader.load();


        Tinsteram model = new Tinsteram();
        loader.<Controller>getController().init(model);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tinsteram");
        stage.show();

    }
}
