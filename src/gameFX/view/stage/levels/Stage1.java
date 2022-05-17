package gameFX.view.stage.levels;

import gameFX.Jeu;
import gameFX.model.personnage.player.Joueur;
import gameFX.model.personnage.pnj.Goblin;
import gameFX.view.stage.Hub;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import static gameFX.model.personnage.player.Joueur.nbrOfMonstersKilled;

public class Stage1 {
    private Stage1(){}

    public static final Scanner scan = new Scanner(System.in);

    public static void lancer(Joueur j) throws InterruptedException {

        int montant = 0;

        System.out.println("Une horde de gobelins arrive !");
        for(int monstres = 1; monstres <= 2; monstres++){
            String goblinName = "goblin" + monstres;
            Goblin goblin = new Goblin(goblinName);
            System.out.println("Un gobelin vous attaque !");
            while ( !(goblin.estMort()) ){
                System.out.println("\n Que souhaitez vous faire ? \n (1) [ATTAQUER]\n (2) [NE RIEN FAIRE]");
                if(!scan.hasNextInt()){
                    System.exit(0);
                }
                int resultInt = scan.nextInt();

                if (resultInt == 1) {
                    goblin.attaquer(j);
                    System.out.println("    ====");
                    TimeUnit.SECONDS.sleep(1);
                    j.attaquer(goblin);
                    TimeUnit.SECONDS.sleep(1);
                } else {
                    goblin.attaquer(j);
                    TimeUnit.SECONDS.sleep(1);
                }
                if (j.estMort())
                    Jeu.jeuPerdant();
            }
            nbrOfMonstersKilled +=1;
            System.out.println("Le gobelin "+ goblin.getNom() +" est mort !");
            j.gainMoney(5);
            montant+=5;
            if (j.canLevelUp())
                j.levelUp();

        }
        System.out.println(" Vous avez tué la horde de gobelins !");
        System.out.println(" Vous avez récolté : " + montant + " pièces d'or");
        TimeUnit.SECONDS.sleep(3);
        Hub.lancer(j);
    }
}
