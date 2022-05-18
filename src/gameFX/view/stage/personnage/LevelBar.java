package gameFX.view.stage.personnage;

import gameFX.Jeu;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

import static gameFX.model.personnage.player.Joueur.nbrOfMonstersKilled;

public class LevelBar {
    private Label lvlInf, lvlSup;
    private ProgressBar pb;

    public LevelBar(Label lvlInf, ProgressBar pb, Label lvlSup){
        this.lvlInf = lvlInf;
        this.pb = pb;
        this.lvlSup = lvlSup;
    }

    public void initializeProgressBar(){
        lvlInf.setText("" + Jeu.player.getExplevel());
        lvlSup.setText("" + (Jeu.player.getExplevel()+1));
        HBox.setMargin(pb, new Insets(10));
        pb.setProgress(nbrOfMonstersKilled * 1.0 / (10*Jeu.player.getExplevel()));
    }
}
