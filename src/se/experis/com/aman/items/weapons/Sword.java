package se.experis.com.aman.items.weapons;

public class Sword implements Weapon,MeleeWeapon {

    private int level;
    private int attackMod;

    public Sword(){
        level = 1;
        attackMod = (int)WeaponBaseStats.MELEE_ATTACK_MODIFIER;
    }

    @Override
    public double getAttackModify() {
        return attackMod;
    }

    @Override
    public void setAttackDamage(int modify) {
        attackMod = modify;
    }

    @Override
    public String weaponType() {
        return "Melee";
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
        return "The Sword of Aragorn";
    }
}
