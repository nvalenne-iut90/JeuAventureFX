package gameFX.stage;

import gameFX.personnage.player.Joueur;


public class Hub {
    private Hub(){}

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
