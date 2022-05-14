package gameFX;


import gameFX.model.Model;
import gameFX.model.personnage.player.Joueur;
import gameFX.view.View;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jeu extends Application {
    public static Scanner scan = new Scanner(System.in);
    public static Joueur player;
    public static final int X_START_MENU = 720;
    public static final int Y_START_MENU = 1080;

    public static void jeuPerdant() throws InterruptedException {
        System.out.println("\nVous êtes mort !");
        TimeUnit.SECONDS.sleep(3);
        System.exit(0);
    }


    private void addListeners(){
    }

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Model model = new Model();
        View view = new View(model, stage);

        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root, X_START_MENU, Y_START_MENU);


        stage.setScene(scene);
        addListeners();
        stage.setTitle("Jeu Aventure");
        stage.setResizable(false);
        stage.show();
    }
}
