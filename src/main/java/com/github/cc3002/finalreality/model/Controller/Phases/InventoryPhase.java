package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

/**
 * Class that will delimit the inventory phase
 */

public class InventoryPhase extends Phase {
    public InventoryPhase(ControllerFF controllerFF) {
        super(controllerFF);
    }

    /**
     * Sends a message to the controller to equip a weapon
     * @param aCharacter name of the character that will equip a weapon
     * @param aWeapon name of the weapon that will be equipped
     */
    @Override
    public void tryToEquip(String aCharacter, String aWeapon){
        controllerFF.equip(aCharacter, aWeapon);
    }
}
