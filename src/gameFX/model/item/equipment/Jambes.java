package gameFX.model.item.equipment;

import gameFX.model.enchantment.*;
import gameFX.model.item.*;

public class Jambes extends Item {
    private int armure;
    public Jambes(String name, int price, String image, int armure){
        super(name, price, image);
        this.armure = armure;
    }
    public Jambes(){
        super("Pantalon en tissu", null, 0, "pantalon_survetOM.png");
        this.armure = 1;
    }
    public Jambes(String name, Enchantment enchantment, int price, int armure, String image){
        super(name, enchantment, price, image);
        this.armure = armure;
    }
}