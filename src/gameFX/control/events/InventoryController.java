package gameFX.control.events;

import gameFX.Jeu;
import gameFX.model.personnage.player.Equipment;
import gameFX.view.stage.personnage.LevelBar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;


public class InventoryController implements Initializable {

    @FXML
    private ProgressBar lvlBar;
    @FXML
    private Label levelInf, levelSup, playerName;
    @FXML
    private HBox hb1, hb2;
    @FXML
    private VBox haut, plastron, pantalon, pieds;

    String haut_URL, plastron_URL, pantalon_URL, pieds_URL;
    ImageView haut_image, plastron_image, pantalon_image, pieds_image;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        playerName.setText(Jeu.player.getNomJoueur());

        LevelBar progressBar = new LevelBar(levelInf, lvlBar, levelSup);
        progressBar.initializeProgressBar();
        Equipment equipment = Jeu.player.getEquipment();

        haut_URL = "/gameFX/model/assets/equipment/" + equipment.getHaut().getImage();
        plastron_URL = "/gameFX/model/assets/equipment/" + equipment.getPlastron().getImage();
        pantalon_URL = "/gameFX/model/assets/equipment/" + equipment.getJambes().getImage();
        pieds_URL = "/gameFX/model/assets/equipment/" + equipment.getPieds().getImage();

        haut_image = new ImageView(haut_URL);
        plastron_image = new ImageView(plastron_URL);
        pantalon_image = new ImageView(pantalon_URL);
        pieds_image = new ImageView(pieds_URL);

        haut.getChildren().add(haut_image);
        plastron.getChildren().add(plastron_image);
        pantalon.getChildren().add(pantalon_image);
        pieds.getChildren().add(pieds_image);


    }
}
