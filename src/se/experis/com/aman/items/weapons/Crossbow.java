package se.experis.com.aman.items.weapons;

public class Crossbow implements Weapon,RangedWeapon{

    private int level;
    private int attackMod;

    public Crossbow(){
        level = 1;
        attackMod = (int)WeaponBaseStats.RANGED_ATTACK_MODIFIER;
    }
    @Override
    public double getAttackModify() {
        return attackMod;
    }

    @Override
    public void setAttackDamage(int modify) {
    this.attackMod=modify;
    }

    @Override
    public String weaponType() {
        return "Ranged";
    }

    @Override
    public void setLevel(int level) {
        this.level=level;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getName() {
        return "The Crossbow of Legolas";
    }
}
