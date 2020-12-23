package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

public class InventoryPhase extends Phase {
    public InventoryPhase(ControllerFF controllerFF) {
        super(controllerFF);
    }

    @Override
    public void tryToEquip(String aCharacter, String aWeapon){
        controllerFF.equip(aCharacter, aWeapon);
    }
}
