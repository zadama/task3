package se.experis.com.aman.characters;

import se.experis.com.aman.factories.WeaponsFactory;
import se.experis.com.aman.items.armor.Armor;
import se.experis.com.aman.items.weapons.*;

public class Ranger extends Hero implements Level {


    private int level;
    private int currentXP;
    private double nextLevelXP;

    public Ranger() {

        super(BaseStats.RANGER_HEALTH, BaseStats.RANGER_STRENGTH, BaseStats.RANGER_DEX, BaseStats.RANGER_INTEL);
        level = 1;
        currentXP = 0;
        nextLevelXP = 100;
    }


    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Methods that calculates and checks wether the
     * Hero can level up or not. If Hero does level up, the
     * stats are updated accordingly, both for the Hero
     * and the carried weapon.
     *
     * The method could be generalized, at least for all "Rangers/Mage", but
     * the decision was not made because we may want to calculate the
     * level change for a particular Ranger differently, in the future, than for
     * the Mage class.
     * @param  xpToAdd  the added XP for the Hero.
     */

    @Override
    public void calculateXpForLevelChange(int xpToAdd) {
        currentXP += xpToAdd;

        if (currentXP >= nextLevelXP) {
            level++;

            CharacterStats updatedStats = super.getHeroStats();

            updatedStats.setHealth(updatedStats.getHealth() + BaseStats.RANGER_ADD_LEVEL_HP);
            updatedStats.setStrength(updatedStats.getStrength() + BaseStats.RANGER_ADD_LEVEL_STR);
            updatedStats.setDex(updatedStats.getDex() + BaseStats.RANGER_ADD_LEVEL_DEX);
            updatedStats.setIntelli(updatedStats.getIntelli() + BaseStats.RANGER_ADD_LEVEL_INT);

            nextLevelXP = (int) (nextLevelXP * 1.1);

            Util.handleWeaponLevelChange(super.getWeapon());

            currentXP = 0;
        }
    }

    @Override
    public double attack() {

        int result = Util.calculateWeaponAttack(super.getWeapon(),super.getHeroStats(),super.getSlotsMapper());


        return result + super.getWeapon().getAttackModify();
    }

    public String toString (){
        int requiredToNextLevel = Util.getRequiredXP(currentXP, nextLevelXP);


        return "Ranger - " + super.toString() +
                "\nLvl: " + level + "\nXP to next: " + requiredToNextLevel;
    }

}
