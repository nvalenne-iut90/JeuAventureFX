package gameFX.model.personnage.player;

import gameFX.model.item.Item;
import gameFX.model.item.equipment.*;
import gameFX.view.stage.Hub;

import static gameFX.Jeu.player;
import static gameFX.Jeu.scan;

public class Equipment {
    private final Item[] equipmentTab;

    public Equipment() {
        this.equipmentTab = new Item[]{
                new Haut(), new Plastron(), new Jambes(), new Pieds()
        };
    }

    public Equipment(Equipment equip) {
        this.equipmentTab = new Item[4];
        for (int i = 0; i < equip.getEquipment().length; i++) {
            equipmentTab[i] = equip.getEquipment()[i];
        }
    }
    public Item[] getEquipment() {
        return equipmentTab;
    }

    public Haut getHaut(){return (Haut) equipmentTab[0];}
    public Plastron getPlastron(){return (Plastron) equipmentTab[1];}
    public Jambes getJambes(){return (Jambes) equipmentTab[2];}
    public Pieds getPieds(){return (Pieds) equipmentTab[3];}

    public void setHaut(Haut haut){equipmentTab[0] = haut;}
    public void setPlastron(Plastron plastron){equipmentTab[1] = plastron;}
    public void setJambes(Jambes jambes){equipmentTab[2] = jambes;}
    public void setPieds(Pieds pieds){equipmentTab[3] = pieds;}

    public void displayEquipment() throws InterruptedException {
        System.out.println("== EQUIPMENT ==");
        for (Item item : equipmentTab) {
            String strCategorieItem, strItem;
            if (item instanceof Haut)
                strCategorieItem = "Haut : ";
            else if (item instanceof Plastron)
                strCategorieItem = "Plastron : ";
            else if (item instanceof Jambes)
                strCategorieItem = "Jambes : ";
            else
                strCategorieItem = "Pieds : ";

            if (item.getNameItem() == null) {
                strItem = strCategorieItem + "Aucun";
                System.out.println(strItem);
            } else {
                strItem = strCategorieItem + item.getNameItem() + " - Prix de revente: " + item.getPrice() + " pièces d'or";
                System.out.println(strItem);
            }
        }
        System.out.println("\nEnter any key to quit...");
        scan.next();
        Hub.lancer(player);
    }

}
