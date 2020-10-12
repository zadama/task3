package se.experis.com.aman.items.armor;

public class Cloth implements Armor {
    @Override
    public String getName() {
        return "The Cloth of Gandalf";
    }

    @Override
    public double getHealth() {
        return ArmorBaseStats.CLOTH_HEALTH;
    }


    public double getIntelli() {
        return ArmorBaseStats.CLOTH_INTELLI;
    }

    @Override
    public double getDex() {
        return ArmorBaseStats.CLOTH_DEX;
    }

    @Override
    public double getStrength() {
        return 0;
    }


}
