package se.experis.com.aman.items.weapons;
/**
 * Common methods among all weapons.
*/
public interface Weapon {

    public double getAttackModify();

    public void setAttackDamage(int modify);

    public String weaponType();

    public void setLevel(int level);

    public int getLevel();

    public String getName();

}
