package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

/**
 * Class that will delimit the main phase of the game
 */
public class MainPhase extends Phase {
    public MainPhase(ControllerFF controllerFF) {
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
}
