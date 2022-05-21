package gameFX.model.item.equipment;

import gameFX.model.enchantment.*;
import gameFX.model.item.*;

public class Haut extends Item {
    private int armure;
    public Haut(String name, int price, int armure, String image){
        super(name, price, image);
        this.armure = armure;
    }
    public Haut(){
        super(null, null,0, "no-item.png");
        this.armure = 0;
    }
    public Haut(String name, Enchantment enchantment, int price, String image, int armure){
        super(name, enchantment, price, image);
        this.armure = armure;
    }
}
