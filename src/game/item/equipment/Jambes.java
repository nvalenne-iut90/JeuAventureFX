package game.item.equipment;

import game.enchantment.Enchantment;
import game.item.Item;

public class Jambes extends Item {
    private int armure;
    public Jambes(String name, int price, int armure){
        super(name, price);
        this.armure = armure;
    }
    public Jambes(){
        super("Pantalon en tissu", null, 0);
        this.armure = 1;
    }
    public Jambes(String name, Enchantment enchantment, int price, int armure){
        super(name, enchantment, price);
        this.armure = armure;
    }
}