package gameFX;


import gameFX.model.personnage.player.Joueur;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jeu extends Application {
    public static Scanner scan = new Scanner(System.in);
    public static Joueur player;
    public static Scene firstScene;
    public static final int X_WINDOW = 600;
    public static final int Y_WINDOW = 800;



    TextField playerName;
    Button play;
    RadioButton male;
    RadioButton female;
    ToggleGroup tgSex;
    VBox vbPlayer;
    HBox hbSex;
    HBox hbLogo;


    public static void jeuPerdant() throws InterruptedException {
        System.out.println("\nVous êtes mort !");
        TimeUnit.SECONDS.sleep(3);
        System.exit(0);
    }

    private Scene createScene(){
        final URL imageURL = getClass().getResource("model/assets/logoJeu.png");
        final ImageView imageView = new ImageView(new Image(imageURL.toExternalForm()));
        imageView.setScaleX(0.7);
        imageView.setScaleY(0.8);

        play = new Button("PLAY");
        play.setStyle("-fx-background-color: #00adff;");
        male = new RadioButton("masculin");
        female = new RadioButton("féminin");
        tgSex = new ToggleGroup();
        male.setToggleGroup(tgSex);
        female.setToggleGroup(tgSex);
        male.setSelected(true);
        playerName = new TextField();
        playerName.setPromptText("Enter your name");
        playerName.setMaxWidth(250);
        playerName.setStyle("-fx-background-color: rgba(250, 184, 114, 0.5);");

        hbSex = new HBox();
        hbLogo = new HBox();
        vbPlayer = new VBox();

        hbLogo.getChildren().add(imageView);
        hbLogo.setAlignment(Pos.CENTER);
        hbSex.getChildren().addAll(male, female);
        hbSex.setAlignment(Pos.CENTER);
        vbPlayer.getChildren().addAll(hbLogo, playerName, hbSex, play);
        vbPlayer.setAlignment(Pos.CENTER);
        VBox.setMargin(playerName, new Insets(15));
        VBox.setMargin(hbSex, new Insets(15));

        firstScene = new Scene(vbPlayer,X_WINDOW,Y_WINDOW);
        // firstScene.getStylesheets().add("styles/stylePlayer.css");
        return firstScene;

    }

    private void addListeners(){
        play.setOnAction(actionEvent -> {
            String sexe = ((RadioButton)male.getToggleGroup().getSelectedToggle()).getText();
            player = new Joueur(playerName.getText(), sexe);// /!\ Création du joueur /!\

            Hub.lancer(player);
        });
    }


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setScene(createScene());
        addListeners();
        stage.setTitle("Jeu Aventure");
        stage.setResizable(false);
        stage.show();
    }
}
