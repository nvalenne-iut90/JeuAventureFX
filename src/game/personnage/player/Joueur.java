package game.personnage.player;

import game.item.Item;
import game.item.Weapon;
import game.item.equipment.Equipment;
import game.personnage.player.classe.ClasseJoueur;
import game.personnage.pnj.PNJ;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Joueur {
    public static final Scanner scan = new Scanner(System.in);
    private static Joueur joueur;
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
    private Weapon poings = new Weapon("poing", 0, "corps à corps", 20, 0, 1, false);

    public Joueur(String nomJoueur, String sexe, int level, Weapon weapon, ClasseJoueur classe, int pv, int portefeuille){
        this.nomJoueur = nomJoueur;
        this.sexe = sexe;
        this.Explevel = level;
        this.weapon = weapon;
        this.classePerso = classe;
        this.pv = pv;
        this.portefeuille = portefeuille;
    }
    public Joueur(String nomJoueur, String sexe, int level, ClasseJoueur classe, int pv, Equipment equipment){
        this.nomJoueur = nomJoueur;
        this.sexe = sexe;
        this.Explevel = level;
        this.weapon = poings;
        this.classePerso = classe;
        this.equipment = equipment;
        this.pv = pv;
        this.portefeuille = 0;
    }
    public Joueur(){
        this.Explevel = 1;
        this.pv = 100;
        this.inventory = new Inventory();
        weapon = poings;
        classePerso = new ClasseJoueur("larbin", 0, 0, 0 ,0, 0);
        this.portefeuille = 0;
        this.equipment = new Equipment();
        this.init();
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


    public void init(){
        System.out.println("Veuillez choisir le sexe de votre personnage   (1) [MASCULIN]   (2) [FEMININ]");
        if (!scan.hasNextInt())
            System.exit(0);
        int tempScan = scan.nextInt();
        if (tempScan == 1)
            sexe = "masculin";
        else if (tempScan == 2)
            sexe = "féminin";
        scan.nextLine();
        System.out.println("Veuillez entrez votre nom : ");
        nomJoueur = scan.nextLine();
    }

    public void levelUp() throws InterruptedException {
        System.out.println("\n==========\n Vous avez gagné un niveau ! " + Explevel + " --> " + (Explevel + 1) + "\n==========");
        setExplevel(Explevel + 1);
        TimeUnit.SECONDS.sleep(2);
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
