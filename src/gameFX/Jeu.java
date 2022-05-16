package gameFX;


import gameFX.model.Model;
import gameFX.model.personnage.player.Joueur;
import gameFX.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class Jeu extends Application {
    public static Scanner scan = new Scanner(System.in);
    public static Joueur player;
    public static final int X_START_MENU = 720;
    public static final int Y_START_MENU = 1080;

    public static void jeuPerdant() {
        System.out.println("\nVous êtes mort !");
        System.exit(0);
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
        stage.getIcons().add(new Image("gameFX/model/assets/icon.png"));
        stage.setTitle("Jeu Aventure");
        stage.setResizable(false);
        stage.show();
    }
}
