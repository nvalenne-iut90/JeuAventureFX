package gameFX.item;

import gameFX.enchantment.Enchantment;

public class Consumable extends Item {
    protected boolean isThrowable;
    public Consumable(String name, Enchantment enchantment, int price, boolean isThrowable){
        super(name, enchantment, price);
        this.isThrowable = isThrowable;
    }
    public Consumable(String name, int price){
        super(name, null, price);
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
