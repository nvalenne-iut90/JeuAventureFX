package gameFX.control.events;

import gameFX.Jeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

public class ControlButton implements EventHandler<ActionEvent> {

    RadioButton temp;
    Jeu app;
    public ControlButton(Jeu application){this.app = application;}

    @Override
    public void handle(ActionEvent event) {
        /*
        if (event.getSource() == app.play){
            String name = app.playerName.getText();
            temp = app.male;
            String sexe = ((RadioButton)temp.getToggleGroup().getSelectedToggle()).getText();
            System.out.println(name + " " + sexe);
            Jeu.player = new Joueur(name, sexe);
            Hub.lancer(Jeu.player);
        }
    */
    }
}
