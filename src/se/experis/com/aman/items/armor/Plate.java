package se.experis.com.aman.items.armor;

public class Plate implements Armor {


    @Override
    public String getName() {
        return "The Plate of Gandalf";

    }

    @Override
    public double getHealth() {
        return ArmorBaseStats.PLATE_HEALTH;
    }

    @Override
    public double getStrength(){
        return ArmorBaseStats.PLATE_STRENGTH;
    }

    @Override
    public double getIntelli() {
        return 0;
    }

    @Override
    public double getDex() {
        return ArmorBaseStats.CLOTH_DEX;
    }


}
