package gameFX.control.events;

import gameFX.Jeu;
import gameFX.model.personnage.player.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class StartController{
    @FXML
    private TextField pseudo;
    @FXML
    private ToggleGroup tgSex;

    @FXML
    public void createPlayer(MouseEvent e) {
        System.out.println("click");
        String name = pseudo.getText();
        String sexe = ((RadioButton)tgSex.getSelectedToggle()).getText();
        System.out.println(name + " " + sexe);
        Jeu.player = new Joueur(name, sexe);

    }
}
