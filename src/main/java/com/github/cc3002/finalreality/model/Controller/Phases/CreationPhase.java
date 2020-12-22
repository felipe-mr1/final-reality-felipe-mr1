package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

import java.util.Random;


public class CreationPhase extends Phase {

    public CreationPhase(ControllerFF controllerFF){
        super(controllerFF);
    }

    @Override
    public void TryToCreatePlayer(String aName, String aClass, String aWeapon, String aWeaponName) throws InvalidActionException {
        Random rng = new Random();
        if(controllerFF.partySize() == 4){return;}
        controllerFF.createPlayer(aName, aClass);
        controllerFF.createWeapon(aWeaponName, rng.nextInt(15)+20, rng.nextInt(15) +30, aWeapon, 0);
        controllerFF.equip(aName, aWeaponName);
        //controllerFF.getPlayer(aName).waitTurn();
    }
}
