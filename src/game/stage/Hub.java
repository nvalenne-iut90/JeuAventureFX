package game.stage;

import game.personnage.player.Joueur;

import java.util.Scanner;


public class Hub {
    private Hub(){}
    private static final Scanner scan = new Scanner(System.in);
    public static void lancer(Joueur joueur) throws InterruptedException {
        System.out.println("==============HUB==============\n" +
                            "Bienvenue dans le hub !");
        System.out.println(" (1)   [PLAY]\n (2)   [SHOP]\n (3)   [INVENTORY]\n (4)   [QUIT]");
        if(!scan.hasNextInt()){
            System.exit(0);
        }
        int resultInt = scan.nextInt();
        switch (resultInt){
            case 1:
                StageMenu.lancer(joueur);
                break;
            case 2:
                Shop.lancer(joueur);
                break;
            case 3:
                joueur.getInventory().displayInventory();
                break;
            default:
                System.exit(0);
        }
    }
}
