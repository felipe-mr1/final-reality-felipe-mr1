package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

/**
 * Class that delimits the end of the game
 */

public class GameOverPhase extends Phase {
    public GameOverPhase(ControllerFF controllerFF) {
        super(controllerFF);
    }

    /**
     * Nothing
     * @param aName name of the character
     * @param aClass class of the character
     * @param aWeapon type of the weapon
     * @param aWeaponName name of the weapon
     */
    @Override
    public void tryToCreatePlayer(String aName, String aClass, String aWeapon, String aWeaponName){}

    /**
     * Nothing
     * @param character name of the character that will equip a weapon
     * @param aWeapon name of the weapon that will be equipped
     */
    @Override
    public void tryToEquip(String character, String aWeapon){}
}
