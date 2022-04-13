package game.enchantment;

public class Enchantment {
    protected int amount, duration;
    protected String typeAffected;
    public Enchantment(int amount, String type, int duration){
        this.amount = amount;
        this.typeAffected = type;
        this.duration = duration;
    }
    public Enchantment(){
        this.amount = 0;
        this.typeAffected = null;
        this.duration = 0;
    }

    public int getAmount() {return amount;}
    public String getTypeAffected() {return typeAffected;}
    public int getDuration() {return duration;}

    public void setAmount(int amount) {this.amount = amount;}
    public void setTypeAffected(String typeAffected) {this.typeAffected = typeAffected;}
    public void setDuration(int duration) {this.duration = duration;}
}
