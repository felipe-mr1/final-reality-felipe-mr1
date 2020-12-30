package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

import java.util.Random;

/**
 * Class that will delimit the creation phase
 */

public class CreationPhase extends Phase {

    public CreationPhase(ControllerFF controllerFF){
        super(controllerFF);
    }

    /**
     * Sends a message to the controller to create a player
     * @param aName name of the character
     * @param aClass class of the character
     * @param aWeapon type of the weapon that will be equipped
     * @param aWeaponName name of the weapon that will be equipped
     */
    @Override
    public void tryToCreatePlayer(String aName, String aClass, String aWeapon, String aWeaponName) {
        Random rng = new Random();
        if(controllerFF.partySize() == 4){return;}
        controllerFF.createPlayer(aName, aClass);
        controllerFF.createWeapon(aWeaponName, rng.nextInt(15)+20, rng.nextInt(15) +30, aWeapon, 0);
        controllerFF.equip(aName, aWeaponName);
    }
}
