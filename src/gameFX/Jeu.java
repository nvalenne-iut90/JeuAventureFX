package gameFX;

import game.personnage.player.Joueur;
import game.stage.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jeu extends Application {
    public static final Scanner scan = new Scanner(System.in);
    public static Joueur player;

    TextField playerName;
    RadioButton male;
    RadioButton female;
    Button play;
    ToggleGroup tgSex;

    VBox vbPlayer;
    HBox hbSex;
    Scene createPlayer;
    GridPane grid;

    public static void jeuPerdant() throws InterruptedException {
        System.out.println("\nVous êtes mort !");
        TimeUnit.SECONDS.sleep(3);
        System.exit(0);
    }
    private void initElements(){
        play = new Button("PLAY");
        male = new RadioButton("Mâle");
        female = new RadioButton("Femelle");
        tgSex = new ToggleGroup();
        male.setToggleGroup(tgSex);
        female.setToggleGroup(tgSex);
        male.setSelected(true);
        playerName = new TextField();
        playerName.setPromptText("Enter your name");

        hbSex = new HBox();
        vbPlayer = new VBox();
    }

    private void displayElements(){
        hbSex.getChildren().addAll(male, female);
        vbPlayer.getChildren().addAll(hbSex);

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(5);
        grid.addRow(0, playerName, vbPlayer);

        createPlayer = new Scene(grid,400,400);

    }


    public static void main(String[] args) throws InterruptedException{
        /*
        StringBuilder welcomeStr = new StringBuilder("Bienvenue sur ce jeu ");
        if ((player.getSexe()).equals("masculin"))
            welcomeStr.append("Guerrier ");
        else
            welcomeStr.append("Guerrière ");
        System.out.println(welcomeStr + player.getNomJoueur() + " !");
        System.out.println(" (1)   [PLAY]\n (2)   [SHOP]\n (3)   [INVENTORY]\n (4)   [QUIT]");
        if(!scan.hasNextInt()){
            System.exit(0);
        }
        int resultInt = scan.nextInt();

        switch (resultInt){
            case 1:
                StageMenu.lancer(player);
                break;
            case 2:
                Shop.lancer(player);
                break;
            case 3:
                player.getInventory().displayInventory();
            default:
                System.exit(0);
        }
        */
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initElements();
        displayElements();
        stage.setScene(createPlayer);
        stage.show();
    }
}
