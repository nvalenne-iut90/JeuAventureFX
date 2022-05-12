package gameFX;


import gameFX.control.events.ControlButton;
import gameFX.model.Model;
import gameFX.model.personnage.player.Joueur;
import gameFX.view.BasicView;
import gameFX.view.stage.Hub;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jeu extends Application {
    public static Scanner scan = new Scanner(System.in);
    public static Joueur player;
    public static Scene startScene;
    public static final int X_WINDOW = 500;
    public static final int Y_WINDOW = 600;

    public TextField playerName;
    public Button play;
    public ToggleGroup tgSex;

    RadioButton male;
    RadioButton female;
    VBox vbPlayer;
    HBox hbSex;
    HBox hbLogo;


    public static void jeuPerdant() throws InterruptedException {
        System.out.println("\nVous êtes mort !");
        TimeUnit.SECONDS.sleep(3);
        System.exit(0);
    }

    private Scene createStartScene(){

        final URL imageURL = getClass().getResource("model/assets/logoJeu.png");
        final ImageView imageView = new ImageView(new Image(imageURL.toExternalForm()));
        imageView.setFitWidth(300);
        imageView.setFitHeight(200);

        play = new Button("PLAY");
        play.setStyle("-fx-background-color: #00adff;");
        male = new RadioButton("Masculin");
        female = new RadioButton("Féminin");
        tgSex = new ToggleGroup();
        male.setToggleGroup(tgSex);
        female.setToggleGroup(tgSex);
        male.setSelected(true);
        playerName = new TextField();
        playerName.setPromptText("Enter your name");
        playerName.setMaxWidth(250);
        // playerName.setStyle("-fx-background-color: rgba(250, 184, 114, 0.5);");

        hbSex = new HBox();
        hbLogo = new HBox();
        vbPlayer = new VBox();

        hbLogo.getChildren().add(imageView);
        hbLogo.setAlignment(Pos.CENTER);
        hbSex.getChildren().addAll(male, female);
        hbSex.setAlignment(Pos.CENTER);
        vbPlayer.getChildren().addAll(hbLogo, playerName, hbSex, play);
        vbPlayer.setAlignment(Pos.CENTER);
        vbPlayer.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        VBox.setMargin(playerName, new Insets(15));
        VBox.setMargin(hbSex, new Insets(15));

        startScene = new Scene(vbPlayer,X_WINDOW,Y_WINDOW);
        // firstScene.getStylesheets().add("styles/stylePlayer.css");
        return startScene;

    }

    private void addListeners(){
        ControlButton controlButton = new ControlButton(this);
        play.setOnAction(controlButton);
    }


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setScene(createStartScene());
        addListeners();
        stage.setTitle("Jeu Aventure");
        stage.setResizable(false);
        stage.show();
    }
}
