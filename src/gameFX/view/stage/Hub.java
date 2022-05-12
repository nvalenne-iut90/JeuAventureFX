package gameFX.view.stage;

import gameFX.model.personnage.player.Joueur;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import static gameFX.Jeu.X_WINDOW;
import static gameFX.Jeu.Y_WINDOW;


public class Hub {
    private Hub(){}

    static Scene createScene(){
        Button btn = new Button("Button");
        HBox hbox = new HBox();
        hbox.getChildren().add(btn);
        return new Scene(hbox, X_WINDOW, Y_WINDOW);
    }

    public static void lancer(Joueur joueur) {
        /*StringBuilder welcomeStr = new StringBuilder();
        if ((player.getSexe()).equals("masculin"))
            welcomeStr.append("Guerrier ");
        else
            welcomeStr.append("Guerrière ");
        welcomeStr.append(player.getNomJoueur()).append(" !");
        System.out.println("==============HUB==============\n" +
                "Bienvenue dans le hub " + welcomeStr);
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
                break;
            default:
                System.exit(0);
        }
        */
    }
}
