package gameFX.control.events;

import gameFX.Jeu;
import gameFX.model.item.equipment.Equipment;
import gameFX.view.stage.personnage.LevelBar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;


public class InventoryController implements Initializable {

    @FXML
    private ProgressBar lvlBar;
    @FXML
    private Label levelInf, levelSup, playerName;
    @FXML
    private HBox hb1, hb2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerName.setText(Jeu.player.getNomJoueur());

        LevelBar progressBar = new LevelBar(levelInf, lvlBar, levelSup);
        progressBar.initializeProgressBar();
        Equipment equipment = Jeu.player.getEquipment();

    }
}
