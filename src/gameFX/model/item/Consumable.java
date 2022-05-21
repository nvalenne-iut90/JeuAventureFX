package gameFX.model.item;

import gameFX.model.enchantment.*;

public class Consumable extends Item {
    protected boolean isThrowable;
    public Consumable(String name, Enchantment enchantment, int price, boolean isThrowable, String image){
        super(name, enchantment, price, image);
        this.isThrowable = isThrowable;
    }
    public Consumable(String name, int price, String image){
        super(name, null, price, image);
        this.isThrowable = false;
    }

    public Enchantment getEnchantment() {return enchantment;}
    public boolean getIsThrowable() {return isThrowable;}

    public void setEnchantment(Enchantment enchantment) {this.enchantment = enchantment;}
    public void setThrowable(boolean throwable) {isThrowable = throwable;}

    @Override
    public String toString() {
        return "Consommable de nom : " + nameItem + " à un prix de " + price + " pièce/s d'or";
    }
}
