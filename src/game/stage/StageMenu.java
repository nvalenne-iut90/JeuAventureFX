package game.stage;

import game.personnage.player.Joueur;
import game.stage.levels.*;

import static gameFX.Jeu.scan;

public class StageMenu {
    public static void lancer(Joueur player) throws InterruptedException {
        System.out.println("(1)   Stage 1\n(2)   Stage 2\n(3)   Stage 3");
        if(!scan.hasNextInt()){
            System.exit(0);
        }
        int resultInt = scan.nextInt();
        switch (resultInt){
            case 1:
                Stage1.lancer(player);
                break;
            case 2:
                Stage2.lancer(player);
                break;
            default:
                Hub.lancer(player);
        }
    }
}
