package se.experis.com.aman.characters;

import se.experis.com.aman.items.armor.Armor;
import se.experis.com.aman.items.weapons.MeleeWeapon;
import se.experis.com.aman.items.weapons.RangedWeapon;
import se.experis.com.aman.items.weapons.Weapon;

import java.util.HashMap;
import java.util.Map;

public class Util {

    public static double calculateSlotsBonus(Map<Slots, Object> bodyParts) {
        double res = 0;


        for (var entry : bodyParts.entrySet()) {

            if(entry.getValue() instanceof Armor){
                var slotArmor = ((Armor) entry.getValue());

                if (entry.getKey().equals(Slots.HEAD)) {
                    res += slotArmor.getStrength() * 0.8;
                }
                if (entry.getKey().equals(Slots.LEGS)) {
                    res += slotArmor.getStrength() * 0.6;
                }

                if (entry.getKey().equals(Slots.BODY)) {
                    res += slotArmor.getStrength() * 1;
                }

            }


        }


        return res;
    }

    public static int getRequiredXP(double currentXP, double nextLevelXP) {

        return (int) Math.round(nextLevelXP - currentXP);
    }

    public static int getArmorValues(Map<Slots, Object> slotsMapper, String stats) {

        int result  = -0;

        for (var entry : slotsMapper.entrySet()) {

            if(entry.getValue() instanceof Armor){
                var slotArmor = ((Armor) entry.getValue());

                if(stats.equals("Health")){
                    result+=slotArmor.getHealth();
                }
               else if(stats.equals("Dex")){

                    result+=slotArmor.getDex();
                }
                else if(stats.equals("Strength")){
                    result+=slotArmor.getStrength();
                }
                else if(stats.equals("Intelli")){
                    result+=slotArmor.getIntelli();
                }

            }
        }



        return  result;

    }

    public static int calculateWeaponAttack(Weapon weapon, CharacterStats characterStats,Map<Slots, Object> slotsMapper) {

        double slotsBonus = calculateSlotsBonus(slotsMapper);

        int weaponTotalAttackDamage = 0;

        if(weapon instanceof MeleeWeapon){

            weaponTotalAttackDamage =  (int)((characterStats.getStrength() + (slotsBonus)) * 1.5);
        }

       else if(weapon instanceof RangedWeapon){

            weaponTotalAttackDamage =  (int)((characterStats.getDex() + (slotsBonus)) * 2 );

        } else{
            System.out.println("The Hero's base stats and armor bonuses could not be included in " +
                    "attack damage. Weapon must be of Melee or Ranged type.." );
        }

        return weaponTotalAttackDamage;
    }

    public static void handleWeaponLevelChange(Weapon weapon) {

        if(weapon instanceof MeleeWeapon){
            weapon.setLevel(weapon.getLevel() + 1);
            weapon.setAttackDamage((int)(weapon.getAttackModify() + 2));
        }

        else if(weapon instanceof RangedWeapon){

            weapon.setLevel(weapon.getLevel() + 1);
            weapon.setAttackDamage((int)(weapon.getAttackModify() + 3));


        } else{
            System.out.println("Make sure that the weapon added to Hero is of type Melee or Ranged.." );
        }
    }
}
