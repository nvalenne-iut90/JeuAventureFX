package gameFX.model.item.equipment;

import gameFX.model.enchantment.Enchantment;
import gameFX.model.item.Item;

public class Plastron extends Item {
    private int armure;
    public Plastron(){
        super("Tee-Shirt WATI-B", null, 0, "plastron_watiB.png");
        this.armure = 0;
    }
    public Plastron(String name, int price, int armure, String image){
        super(name, price, image);
        this.armure = armure;
    }
    public Plastron(String name, Enchantment enchantment, int price, int armure, String image){
        super(name, enchantment, price, image);
        this.armure = armure;
    }
}