package game.personnage.player.classe;

import java.util.Scanner;

public class Competences {
    Scanner scan = new Scanner(System.in);
    protected int force, agilite, defense, speedAttack, furtivite;
    public Competences(int force, int agilite, int defense, int furtivite, int vit){
        this.force = force;
        this.agilite = agilite;
        this.defense = defense;
        this.furtivite = furtivite;
        this.speedAttack = vit;
    }
    public Competences(){
        this.init();
    }

    public int getForce() {return force;}
    public int getAgilite() {return agilite;}
    public int getDefense() {return defense;}
    public int getFurtivite() {return furtivite;}
    public int getSpeedAttack() {return speedAttack;}

    public void setForce(int force) {this.force = force;}
    public void setAgilite(int agilite) {this.agilite = agilite;}
    public void setDefense(int defense) {this.defense = defense;}
    public void setFurtivite(int furtivite) {this.furtivite = furtivite;}
    public void setSpeedAttack(int speedAttack) {this.speedAttack = speedAttack;}

    public void init(){
        do {
            System.out.println("Sur une échelle de 1 à 10");
            System.out.print("Agilité :");
            agilite = scan.nextInt();
            System.out.print("Defense :");
            defense = scan.nextInt();
            System.out.print("Furtivité :");
            furtivite = scan.nextInt();
            System.out.print("Vitesse d'attaque :");
            speedAttack = scan.nextInt();
        } while(force > 10 || agilite > 10 || defense > 10 || furtivite > 10 || speedAttack > 10);
    }
}
