package gameFX.control.events;

import gameFX.Jeu;
import gameFX.model.personnage.player.Joueur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController{
    @FXML
    private TextField pseudo;
    @FXML
    private ToggleGroup tgSex;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void createPlayer(MouseEvent e) throws IOException {
        String name = pseudo.getText();
        String sexe = ((RadioButton)tgSex.getSelectedToggle()).getText();
        Jeu.player = new Joueur(name, sexe);

        root = FXMLLoader.load(getClass().getResource("/gameFX/view/stage/hub.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
