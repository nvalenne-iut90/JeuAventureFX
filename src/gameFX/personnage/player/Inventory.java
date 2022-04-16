package gameFX.personnage.player;

import gameFX.item.Item;
import gameFX.stage.Hub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static gameFX.Jeu.player;


public class Inventory {
    private static final Scanner scan = new Scanner(System.in);
    private List<Item> inventory;
    public static final int CAPACITY = 30;

    public Inventory(){
        this.inventory = new ArrayList<>(CAPACITY);
    }

    public Inventory(List<Item> inventory){
        this.inventory = inventory;
    }

    public List<Item> getInventory() {return inventory;}

    public void displayInventory() throws InterruptedException {
        System.out.println("== INVENTORY ==");
        for (Item item : inventory) {
            System.out.println(item.getNameItem() + " - Prix de revente: " + item.getPrice() + " pièces d'or" );
        }
        if (inventory.isEmpty()){
            System.out.println(" Aucun item disponible dans votre inventaire...");
        }
        System.out.println("\n(1)   [EQUIPMENT]\n(0)   [QUIT]");
        if(!scan.hasNextInt() || scan.nextInt() != 1)
            Hub.lancer(player);
        else
            player.getEquipment().displayEquipment();
    }


}
