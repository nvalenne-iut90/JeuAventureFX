package gameFX.control.events;

import gameFX.Jeu;
import gameFX.view.stage.personnage.LevelBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HubController implements Initializable {
    @FXML
    private Label welcome, levelInf, levelSup;
    @FXML
    ProgressBar lvlBar;

    private Parent root;
    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if ((Jeu.player.getSexe()).equals("Masculin")) {
            welcome.setText("Bienvenue Guerrier " + Jeu.player.getNomJoueur());
        } else if ((Jeu.player.getSexe()).equals("Féminin")) {
            welcome.setText("Bienvenue Guerrière " + Jeu.player.getNomJoueur());
        }

        LevelBar progressBar = new LevelBar(levelInf, lvlBar, levelSup);
        progressBar.initializeProgressBar();
    }

    @FXML
    public void goToStages(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/gameFX/view/stage/stageMenu.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToShop(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/gameFX/view/stage/shop.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToInventory(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/gameFX/view/stage/personnage/inventory.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void quit(ActionEvent e) {
        System.out.println("Au revoir....");
        System.exit(0);
    }
}
