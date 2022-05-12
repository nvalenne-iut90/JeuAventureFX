package gameFX.view.stage;

import gameFX.Jeu;
import gameFX.model.item.*;
import gameFX.model.personnage.player.Joueur;
import gameFX.model.personnage.pnj.PNJ;

import java.util.Scanner;

public class Shop {
    private static Item[] articlesVente;

    private static final Scanner scan = new Scanner(System.in);
    private static int resultInt;
    public static void lancer(Joueur j) throws InterruptedException {
        PNJ marchand = new PNJ("Marchand Pierre");
        articlesVente = new Item[]{
                new Consumable("Pomme", 2),
                new Weapon("Epée en bois", 10, "arme blanche", 10, 3, 1, false)

        };

        marchand.parle(marchand.getNom() + ": Bienvenue guerrier/ère ! N'hésites pas à regarder notre collection !" );
        System.out.println("(1)   [BUY]\n(2)   [SELL]\n(0)   [BACK]");
        if(!scan.hasNextInt()){
            System.exit(0);
        }
        resultInt = scan.nextInt();
        switch (resultInt){
            case 0:
                Hub.lancer(Jeu.player);
                break;
            case 1:
                Shop.buyToShopper(j);
                break;
            case 2:
                Shop.sellToShopper(j);
                break;
            default:
                System.exit(0);
        }
    }

    private static void buyToShopper(Joueur j) throws InterruptedException {
        for (int i = 0; i < articlesVente.length ; i++){
            System.out.println("(" + (i+1) + ") " + articlesVente[i].getNameItem() + " : " + articlesVente[i].getPrice() + " pièces d'or");
        }
        System.out.println("Or : " + j.getPortefeuille());
        if(!scan.hasNextInt()){
            System.exit(0);
        }
        resultInt = scan.nextInt();

        for (int i = 0; i < articlesVente.length ; i++){
            if ((resultInt-1) == i){
                if (j.getPortefeuille() >= articlesVente[i].getPrice()){
                    j.addItemInInventory(articlesVente[i]);
                    j.spendMoney(articlesVente[i].getPrice());
                } else {
                    System.out.println(" /!\\ Vous n'avez pas assez de pièces d'or pour vous procurer cet objet ! /!\\");
                }
            }
        }
        Shop.lancer(j);
    }
    private static void sellToShopper(Joueur j) throws InterruptedException {
        for (int i = 0; i < j.getInventoryItems().size(); i++){
            System.out.println("(" + (i+1) + ") " + j.getInventoryItems().get(i).getNameItem() + " : " + j.getInventoryItems().get(i).getPrice() + " pièces d'or");
        }
        if(!scan.hasNextInt()){
            System.exit(0);
        }
        resultInt = scan.nextInt();
        for (int i = 0; i < j.getInventoryItems().size() ; i++){
            if ((resultInt-1) == i){
                j.gainMoney(j.getInventoryItems().get(i).getPrice());
                j.removeItemFromInventory(j.getInventoryItems().get(i));
            }
        }
        Shop.lancer(j);

    }
}
