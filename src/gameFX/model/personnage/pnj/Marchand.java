package gameFX.model.personnage.pnj;

public class Marchand extends PNJ {
    protected String typeMarchand;
    public Marchand(String n, String type){
        super(n, 1000);
        this.typeMarchand = type;
    }
}
