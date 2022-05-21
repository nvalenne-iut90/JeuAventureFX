package gameFX.model.item;

import gameFX.model.enchantment.*;

public class Item {
    protected Enchantment enchantment;
    protected String nameItem, image;
    protected int price;
    public Item(String name, Enchantment enchantment, int price, String image){
        this.nameItem = name;
        this.enchantment = enchantment;
        this.price = price;
        this.image = image;
    }
    public Item(String name, int price, String image){
        this.nameItem = name;
        this.enchantment = null;
        this.price = price;
        this.image = image;
    }
    public Item(){}
    public Enchantment getEnchantment() {return enchantment;}
    public String getNameItem() {return nameItem;}
    public int getPrice() {return price;}
    public String getImage(){return image;}

    public void setEnchantment(Enchantment enchantment) {this.enchantment = enchantment;}
    public void setNameItem(String nameItem) {this.nameItem = nameItem;}
    public void setPrice(int price) {
        this.price = price;
    }
    public void setImage(String image) {this.image = image;}
}
