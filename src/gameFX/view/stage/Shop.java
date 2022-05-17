package gameFX.view.stage;

import gameFX.Jeu;
import gameFX.model.item.*;
import gameFX.model.personnage.player.Joueur;
import gameFX.model.personnage.pnj.PNJ;

import java.util.Scanner;

public class Shop {
    private Item[] articlesVente;

    private static final Scanner scan = new Scanner(System.in);
    private static int resultInt;
    public Shop(){
        this.articlesVente = new Item[]{
                new Consumable("Pomme", 2),
                new Weapon("Epée en bois", 10, "arme blanche", 10, 3, 1, false)
        };

    }

    public Item[] getArticlesVente() {
        return articlesVente;
    }

    private void buyToShopper(Joueur j) {
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
    }
    private void sellToShopper(Joueur j){
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

    }
}
