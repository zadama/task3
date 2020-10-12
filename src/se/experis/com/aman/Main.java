package se.experis.com.aman;

import se.experis.com.aman.characters.*;
import se.experis.com.aman.characters.Hero;
import se.experis.com.aman.factories.ArmorFactory;
import se.experis.com.aman.factories.HeroesFactory;
import se.experis.com.aman.factories.WeaponsFactory;
import se.experis.com.aman.items.armor.Armor;
import se.experis.com.aman.items.armor.ArmorTypes;
import se.experis.com.aman.items.weapons.Weapon;
import se.experis.com.aman.items.weapons.WeaponTypes;

public class Main {

    public static void print(String result){
        System.out.println(result);
    }

    public static void main(String[] args) {

        HeroesFactory h1 = new HeroesFactory();
        WeaponsFactory w1 = new WeaponsFactory();
        ArmorFactory a1 = new ArmorFactory();

        Hero aragon = h1.create(HeroTypes.WARRIOR);
        Weapon sword = w1.create(WeaponTypes.SWORD);
        Armor plate =a1.create(ArmorTypes.PLATE);

        aragon.equipWeapon(sword);
        aragon.equipFullArmor(plate,new Slots[]{Slots.BODY, Slots.LEGS, Slots.HEAD});

        aragon.setName("Aman Zadran");
        print("------------");


        print(aragon + "\n");
        print("Item stats for " + aragon.getWeapon().getName());
        print("Weapon type: " + aragon.getWeapon().weaponType());
        print("Weapon level: " + aragon.getWeapon().getLevel());
        print("Weapon damage: " + aragon.getWeapon().getAttackModify() + "\n");

        print("Leveling...\n");
        aragon.calculateXpForLevelChange(100 );
        print(aragon + "\n");

        print("Item stats for " + aragon.getWeapon().getName());
        print("Weapon type: " + aragon.getWeapon().weaponType());
        print("Weapon level: " + aragon.getWeapon().getLevel());
        print("Weapon damage: " + aragon.getWeapon().getAttackModify());

        print( "\n"+aragon.getName() + " attack amount: " + aragon.attack());



    }
}
