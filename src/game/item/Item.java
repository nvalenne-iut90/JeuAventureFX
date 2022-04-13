package game.item;

import game.enchantment.*;

public class Item {
    protected Enchantment enchantment;
    protected String nameItem;
    protected int price;
    public Item(String name, Enchantment enchantment, int price){
        this.nameItem = name;
        this.enchantment = enchantment;
        this.price = price;
    }
    public Item(String name, int price){
        this.nameItem = name;
        this.enchantment = null;
        this.price = price;
    }
    public Item(){}
    public Enchantment getEnchantment() {return enchantment;}
    public String getNameItem() {return nameItem;}
    public int getPrice() {return price;}

    public void setEnchantment(Enchantment enchantment) {this.enchantment = enchantment;}
    public void setNameItem(String nameItem) {this.nameItem = nameItem;}
}
