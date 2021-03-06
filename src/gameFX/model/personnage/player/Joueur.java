package gameFX.model.personnage.player;

import gameFX.model.item.*;
import gameFX.model.personnage.player.classe.ClasseJoueur;
import gameFX.model.personnage.pnj.PNJ;

import java.util.List;

public class Joueur {
    public static int nbrOfMonstersKilled = 0;

    private String sexe;
    private String nomJoueur;
    private int Explevel;
    private int pv;
    private int portefeuille;
    private ClasseJoueur classePerso;
    private Inventory inventory;
    private Equipment equipment;
    private Weapon weapon;
    private Weapon poings = new Weapon("poing", 0, "corps à corps", 20, 0, 1, false, "");

    public Joueur(String nomJoueur, String sexe){
        this.nomJoueur = nomJoueur;
        this.sexe = sexe;
        this.Explevel = 1;
        this.pv = 100;
        this.inventory = new Inventory();
        weapon = poings;
        classePerso = new ClasseJoueur("larbin", 0, 0, 0 ,0, 0);
        this.portefeuille = 0;
        this.equipment = new Equipment();
    }

    public int getExplevel() {return Explevel;}
    public String getSexe() {return sexe;}
    public ClasseJoueur getClassePerso() {return classePerso;}
    public Weapon getWeapon() {return weapon;}
    public int getPv() {return pv;}
    public String getNomJoueur() {return nomJoueur;}
    public int getPortefeuille() {return portefeuille;}
    public Inventory getInventory() {return inventory;}
    public List<Item> getInventoryItems(){return inventory.getInventory();}
    public Equipment getEquipment() {return equipment;}
    public Item[] getEquipmentItems() {
        return equipment.getEquipment();
    }

    public void setExplevel(int explevel) {this.Explevel = explevel;}
    public void setPv(int pv) {this.pv = pv;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}

    public void addItemInInventory(Item item){
        inventory.getInventory().add(item);
    }
    public void removeItemFromInventory(Item item){
        inventory.getInventory().remove(item);
    }

    public void levelUp() throws InterruptedException {
        System.out.println("\n==========\n Vous avez gagné un niveau ! " + Explevel + " --> " + (Explevel + 1) + "\n==========");
        setExplevel(Explevel + 1);
    }

    public boolean canLevelUp() {
        return (nbrOfMonstersKilled % (10*Explevel) == 0);
    }

    public String toString() {
        return "Joueur " + nomJoueur + " de sexe " + sexe + "\n"
                + ", de classe " + classePerso.getNameClasse() + " de niveau " + Explevel + "\n"
                + ", possède une arme : " + weapon.getNameItem() + "\n"
                + "a une vitalité de " + pv + " PVs\n" +
                "Il possede " + portefeuille + " pièces d'or";
    }

    public void perdsPV(int pvLost){this.pv -= pvLost;}
    public void gagnePV(int pvGained){this.pv += pvGained;}
    public void spendMoney(int amount){this.portefeuille -= amount;}
    public void gainMoney(int amount){this.portefeuille += amount;}

    public boolean estMort(){return this.pv <= 0;}

    public void attaquer(PNJ pnj){
        float ccritic = (float) 0.1;

        System.out.println( this.getNomJoueur() + " attaque " + pnj.getNom() );
        int degats = this.getWeapon().getDamage();

        if (Math.random() <= ccritic){
            degats *= 2;
            System.out.println("Coup critique ! ");
        }
        pnj.perdsPV(degats);
        System.out.println("Le PNJ " + pnj.getNom() + " a perdu " + degats + " PV !" + "\n" +
                "PVs du PNJ : " + pnj.getPv());
    }

    public void acheter(Item item) {
        if (portefeuille >= item.getPrice()){
            addItemInInventory(item);
            portefeuille -= item.getPrice();
            System.out.println();
            System.out.println("test");
        } else {
            System.out.println("Vous n'avez pas assez de pièces d'or pour vous procurer cet objet !");
        }
    }

}
