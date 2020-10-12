package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.util.concurrent.BlockingQueue;

public class WhiteMage extends PlayerCharacter {
    double mana;
    int defensePoints;
    public WhiteMage(final java.lang.String name,
                     final BlockingQueue<ICharacter> turnsQueue,
                     final String characterClass) {
        super(name, turnsQueue, characterClass, 500);
        this.mana = 200;
        this.defensePoints = 100;
    }

    public void equip(IWeapon weapon) {
        weapon.equip(this);
        super.equip(weapon);
    }
    //public void equip(IWeapon weapon) throws Exception {
        //if (!(weapon instanceof Staff)){
            //throw new Exception("Can't equip that type of weapon");
        //}
        //super.equip(weapon);
    //}

    //public double heal(){
        //assert this.mana > 15;
        //this.mana -= 15;
        //return 0.3;
    //}
    //public void poison(){
        //assert this.mana > 40;
        //this.mana -= 40;
    //}
    //public void paralyze(){
        //assert this.mana > 30;
        //this.mana -= 30;
    //}
}
