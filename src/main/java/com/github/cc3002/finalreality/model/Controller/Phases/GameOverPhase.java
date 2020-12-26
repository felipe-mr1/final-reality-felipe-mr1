package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

public class GameOverPhase extends Phase {
    public GameOverPhase(ControllerFF controllerFF) {
        super(controllerFF);
    }
    @Override
    public void tryToCreatePlayer(String aName, String aClass, String aWeapon, String aWeaponName){}

    @Override
    public void tryToEquip(String character, String aWeapon){}
}
