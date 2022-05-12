package gameFX.model.item.equipment;

import gameFX.model.enchantment.*;
import gameFX.model.item.*;

public class Pieds extends Item {
    private int armure;
    public Pieds(){
        super("Pantoufles Mickey", null, 1);
        this.armure = 0;
    }
    public Pieds(String name, int price, int armure){
        super(name, price);
        this.armure = armure;
    }
    public Pieds(String name, Enchantment enchantment, int price, int armure){
        super(name, enchantment, price);
        this.armure = armure;
    }
}