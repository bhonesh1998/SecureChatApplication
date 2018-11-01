package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class Server extends Application {

    private double xOffset, yOffset;

    @Override
    public void start(Stage primaryStage) throws Exception {

        new RSA().createRSA();

        File file = new File(Constants.appFile);
        primaryStage.setOnHiding(event -> {
            file.delete();
        } );

        Parent root = FXMLLoader.load(getClass().getResource("serverFrame.fxml"));

        root.setOnMousePressed(event12 -> {
            xOffset = event12.getSceneX();
            yOffset = event12.getSceneY();
        });

        root.setOnMouseDragged(event1 -> {
            primaryStage.setX(event1.getScreenX() - xOffset);
            primaryStage.setY(event1.getScreenY() - yOffset);
        });

        primaryStage.setTitle("Server Messenger");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
