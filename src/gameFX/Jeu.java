package gameFX;

import gameFX.events.ControlButton;
import gameFX.personnage.player.Joueur;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jeu extends Application {
    public static Scanner scan = new Scanner(System.in);
    public static Joueur player;
    public static Scene createPlayer;



    public TextField playerName;
    public Button play;
    public RadioButton male;
    RadioButton female;
    ToggleGroup tgSex;
    // Image gameLogo = new Image(new FileInputStream("~/Documents/JeuAventureFX/src/gameFX/assets/logoJeu.png"));
    VBox vbPlayer;
    HBox hbSex;


    public static void jeuPerdant() throws InterruptedException {
        System.out.println("\nVous êtes mort !");
        TimeUnit.SECONDS.sleep(3);
        System.exit(0);
    }
    private void initElements(){
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
        playerName.setMaxWidth(200);

        hbSex = new HBox();
        vbPlayer = new VBox();
    }

    private void displayElements(){
        hbSex.getChildren().addAll(male, female);
        hbSex.setAlignment(Pos.CENTER);
        vbPlayer.getChildren().addAll(playerName, hbSex, play);
        vbPlayer.setAlignment(Pos.CENTER);
        VBox.setMargin(playerName, new Insets(15));
        VBox.setMargin(hbSex, new Insets(15));

        createPlayer = new Scene(vbPlayer,600,500);
        createPlayer.getStylesheets().add("styles/stylePlayer.css");

    }

    private void addListeners(){
        ControlButton cb = new ControlButton(this);
        play.setOnAction(cb);
    }


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        initElements();
        displayElements();
        addListeners();
        stage.setScene(createPlayer);
        stage.show();
    }
}
