package gameFX.item.equipment;

import gameFX.enchantment.Enchantment;
import gameFX.item.Item;

public class Plastron extends Item {
    private int armure;
    public Plastron(){
        super("Tee-Shirt WATI-B", null, 0);
        this.armure = 0;
    }
    public Plastron(String name, int price, int armure){
        super(name, price);
        this.armure = armure;
    }
    public Plastron(String name, Enchantment enchantment, int price, int armure){
        super(name, enchantment, price);
        this.armure = armure;
    }
}