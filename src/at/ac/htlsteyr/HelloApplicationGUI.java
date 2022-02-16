package at.ac.htlsteyr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class
HelloApplicationGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader() //getClass().getResource("hello-view.fxml"));
        final FXMLLoader fxmlLoader = new FXMLLoader();
        URL u = HelloApplicationGUI.class.getResource("hello-view.fxml");
        System.out.println(new File("").getAbsolutePath());
        System.out.println(u);
        fxmlLoader.setLocation(u);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("VierGewinnt");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}