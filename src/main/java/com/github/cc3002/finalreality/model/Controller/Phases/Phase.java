package com.github.cc3002.finalreality.model.Controller.Phases;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;

public class Phase {
    protected ControllerFF controllerFF;

    public Phase(ControllerFF controllerFF){
        this.controllerFF = controllerFF;
    }

    public void setControllerFF(ControllerFF aControllerFF){
        this.controllerFF = aControllerFF;
    }

    protected void changePhase(Phase phase){
        controllerFF.setPhase(phase);
    }

    public void toMainPhase1() throws InvalidTransitionException {
        throw new InvalidTransitionException("Cant Change to main phase");
    }

    public void toAttackPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("Cant Change to Attack Phase");
    }

    public void toInventoryPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("Cant Change to Inventory Phase");
    }

    public void toEquipPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("Cant Change to Equip Phase");
    }

    public void TryToCreatePlayer(String aName, String aClass, String aWeapon, String aWeaponName) throws InvalidActionException{
        throw new InvalidActionException("Cant create");
    }

    public void tryToAttack(String aName, String target)throws InvalidActionException{
        throw new InvalidActionException("Cant attack");
    }
}
