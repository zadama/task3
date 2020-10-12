package se.experis.com.aman.factories;

import se.experis.com.aman.items.weapons.*;

public class WeaponsFactory {

    /**
     * Creates a weapon object according to the type.
     * @param  types  the type of Weapon to be created, e.g. sword, wand etc.
     * @return      the Armor
     */


    public Weapon create (WeaponTypes types){

        switch (types){
            case WAND:
                return new Wand();

            case SWORD:
                return new Sword();
            case CROSSBOW:
                return new Crossbow();

        }

        return  null;
    }

}
