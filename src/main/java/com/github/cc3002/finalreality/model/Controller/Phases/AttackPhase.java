package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

public class AttackPhase extends Phase{
    public AttackPhase(ControllerFF controllerFF) {
        super(controllerFF);
    }

    public void tryToAttack(String aName, String aTarget){
        controllerFF.attack(aName, aTarget);
        controllerFF.setPhase(new MainPhase(controllerFF));
    }
}
