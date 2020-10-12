package se.experis.com.aman.factories;

import se.experis.com.aman.characters.*;
import se.experis.com.aman.characters.Hero;

public class HeroesFactory {

    /**
     * Creates a Hero object according to the type.
     * @param  types  the type of Hero to be created, e.g. warrior, mage etc.
     * @return      the Hero
     */


    public Hero create(HeroTypes types) {
        switch (types) {
            case MAGE:
                return new Mage();
            case WARRIOR:
                return new Warrior();
            case RANGER:
                return new Ranger();
            default:
                return null;

        }

    }
}


