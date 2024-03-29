package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

/**
 * Class that will delimit the phases and dynamics of the game
 */

public class Phase {
    protected ControllerFF controllerFF;

    public Phase(ControllerFF controllerFF){
        this.controllerFF = controllerFF;
    }

    public void setControllerFF(ControllerFF aControllerFF){
        this.controllerFF = aControllerFF;
    }


    public void tryToCreatePlayer(String aName, String aClass, String aWeapon, String aWeaponName) throws InvalidActionException{
        throw new InvalidActionException("Cant create");
    }

    public void tryToAttack(String aName, String target)throws InvalidActionException{
        throw new InvalidActionException("Cant attack");
    }

    public void tryToEquip(String character, String aWeapon) throws InvalidActionException{
        throw new InvalidActionException("Cant Equip");
    }

}
