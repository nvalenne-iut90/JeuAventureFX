package game.personnage.player.classe;

public class ClasseJoueur extends Competences{
    protected String nameClasse;
    public ClasseJoueur(String name,int force, int agilite, int defense, int furtivite, int vit){
        super(force, agilite, defense, furtivite, vit);
        this.nameClasse = name;
    }

    public String getNameClasse() {return nameClasse;}
    public void setNameClasse(String nameClasse) {this.nameClasse = nameClasse;}


    public String toString() {
        return "Classe " + nameClasse + "\n" +
                " - Force : " + force + "\n" +
                " - Agilité : " + agilite + "\n" +
                " - Défense : " + defense + "\n" +
                " - Furtivité : " + furtivite + "\n" +
                " - Vitesse d'attaque : " + speedAttack;
    }
}
