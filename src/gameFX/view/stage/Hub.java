package gameFX.view.stage;

import gameFX.model.personnage.player.Joueur;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import static gameFX.Jeu.*;


public class Hub {
    private Hub(){}

    static Scene createScene(){
        Button btn = new Button("Button");
        HBox hbox = new HBox();
        hbox.getChildren().add(btn);
        return new Scene(hbox, X_START_MENU, Y_START_MENU);
    }

    public static void lancer(Joueur joueur) {
    }
}
