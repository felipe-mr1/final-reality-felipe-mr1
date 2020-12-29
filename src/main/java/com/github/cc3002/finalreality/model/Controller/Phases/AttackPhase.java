package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

/**
 * Class that will delimit the attack phase
 */

public class AttackPhase extends Phase{
    public AttackPhase(ControllerFF controllerFF) {
        super(controllerFF);
    }

    /**
     * Sends a message to the controller to attack a target
     * @param aName name of the character that will attack
     * @param aTarget name of the target that will be attacked
     */
    @Override
    public void tryToAttack(String aName, String aTarget){
        controllerFF.attack(aName, aTarget);
        controllerFF.setPhase(new MainPhase(controllerFF));
    }
}
