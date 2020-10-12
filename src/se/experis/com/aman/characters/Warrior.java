package se.experis.com.aman.characters;

import se.experis.com.aman.items.armor.Armor;
import se.experis.com.aman.items.weapons.MeleeWeapon;
import se.experis.com.aman.items.weapons.RangedWeapon;
import se.experis.com.aman.items.weapons.Sword;
import se.experis.com.aman.items.weapons.Weapon;

import java.util.HashMap;
import java.util.Map;

public class Warrior extends Hero implements Level {

    private int level;
    private int currentXP;
    private int nextLevelXP;

    public Warrior() {
        super(BaseStats.WARRIOR_HEALTH, BaseStats.WARRIOR_STRENGTH, BaseStats.WARRIOR_DEX, BaseStats.WARRIOR_INTEL);
        level = 1;
        currentXP = 0;
        nextLevelXP = 100;

    }


    @Override
    public double attack() {


        int result = Util.calculateWeaponAttack(super.getWeapon(),super.getHeroStats(),super.getSlotsMapper());


        return result + super.getWeapon().getAttackModify();
    }

    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Methods that calculates and checks wether the
     * Hero can level up or not. If Hero does level up, the
     * stats are updated accordingly, both for the Hero
     * and the carried weapon
     * @param  xpToAdd  the added XP for the Hero.
     */

    @Override
    public void calculateXpForLevelChange(int xpToAdd) {

        currentXP += xpToAdd;

        if (currentXP >= nextLevelXP) {
            level++;

            CharacterStats updatedStats = super.getHeroStats();

            updatedStats.setHealth(updatedStats.getHealth() + BaseStats.WARRIOR_ADD_LEVEL_HP);
            updatedStats.setStrength(updatedStats.getStrength() + BaseStats.WARRIOR_ADD_LEVEL_STR);
            updatedStats.setDex(updatedStats.getDex() + BaseStats.WARRIOR_ADD_LEVEL_DEX);
            updatedStats.setIntelli(updatedStats.getIntelli() + BaseStats.WARRIOR_ADD_LEVEL_INT);

            nextLevelXP = (int) (nextLevelXP * 1.1);

            currentXP = 0;

            Util.handleWeaponLevelChange(super.getWeapon());
        }

    }

    public String toString() {
        int requiredToNextLevel = Util.getRequiredXP(currentXP, nextLevelXP);


        return "Warrior - " + super.toString() +
                        "\nLvl: " + level + "\nXP to next: " + requiredToNextLevel;
    }
}
