package se.experis.com.aman.characters;

import se.experis.com.aman.items.armor.Armor;
import se.experis.com.aman.items.weapons.Weapon;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Hero class that contains properties and methods
 * that are common amongst the subclasses.
 */

public abstract class Hero implements CharacterStatsChanger, Level {
    private String name;
    private CharacterStats characterStats;
    private Armor armor;
    private Weapon weapon;

    private Map<Slots, Object> slotsMapper;

    public Hero(double health, double strength, double dex, double intelli) {
        this.name = "";
        characterStats = new CharacterStats(health, strength, dex, intelli);
        slotsMapper = new HashMap<Slots, Object>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void changeLegsArmor(Armor armor) {
        slotsMapper.put(Slots.LEGS, armor);
    }

    public void changeHeadArmor(Armor armor) {
        slotsMapper.put(Slots.HEAD, armor);
    }

    public void changeBodyArmor(Armor armor) {
        slotsMapper.put(Slots.BODY, armor);
    }

    @Override
    public void setHeroStats(CharacterStats stats) {
        this.characterStats = stats;
    }

    @Override
    public CharacterStats getHeroStats() {
        return characterStats;
    }

    /**
     * Adds the provided armor to all slots as default.
     * @param  armor  the armor to be added, e.g. plate, cloth etc.
     * @param  parts the slots to be added to, e.g. head, body etc.
     */

    public void equipFullArmor(Armor armor, Slots[] parts) {
        this.armor = armor;

        for (Slots part : parts) {
            slotsMapper.put(part, armor);
        }
    }

    /**
     * Adds a weapon the the "weapon" slot.
     * @param  weapon  the weapon to be added, e.g. sword, wand etc.
     */

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;

        slotsMapper.put(Slots.WEAPON, weapon);
    }

    public Map<Slots, Object> getSlotsMapper() {
        return slotsMapper;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public abstract double attack();

    /**
     * The values for the different heros are printed.
     * The armor stats are added to the hero's base stats before
     * printing.
     */

    public String toString() {

        int armorHealth = Util.getArmorValues(slotsMapper, "Health");
        int armorStrength = Util.getArmorValues(slotsMapper, "Strength");

        int armorDex = Util.getArmorValues(slotsMapper, "Dex");

        int armorIntelli = Util.getArmorValues(slotsMapper, "Intelli");


        return
                name + " details:"
                        + "\nHP: " + (int) (characterStats.getHealth() + armorHealth)
                        + "\nStr: " + (int) (characterStats.getStrength() + armorStrength)
                        + "\nDex: " + (int) (characterStats.getDex() + armorDex)
                        + "\nIntelli: " + (int) (characterStats.getIntelli() + armorIntelli);
    }


}
