package se.experis.com.aman.factories;

import se.experis.com.aman.items.armor.*;

public class ArmorFactory {

    /**
     * Creates an armor object according to the type.
     * @param  types  the type of Armor to be created, e.g. cloth, plate etc.
     * @return      the Armor
     */

    public Armor create(ArmorTypes types) {

        switch (types) {
            case CLOTH:
                return new Cloth();
            case PLATE:
                return new Plate();

            case LEATHER:
                return new Leather();

            default:
                return null;
        }


    }
}
