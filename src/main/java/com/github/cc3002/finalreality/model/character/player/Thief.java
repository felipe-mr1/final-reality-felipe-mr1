package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

public class Thief extends PlayerCharacter {
    int defensePoints;
    public Thief(final java.lang.String name,
                    final BlockingQueue<ICharacter> turnsQueue,
                    final String characterClass){
        super(name, turnsQueue, characterClass, 600);
        this.defensePoints = 100;
    }
    public void equip(IWeapon weapon) {
        weapon.equip(this);
    }

    @Override
    public void equipStaff(Staff staff){super.equip(staff);}

    @Override
    public void equipSword(Sword sword){super.equip(sword);}
    //public void equip(IWeapon weapon) throws Exception {
        //if (!(weapon instanceof Sword | weapon instanceof Bow | weapon instanceof Staff)){
            //throw new Exception("Can't equip that type of weapon");
        //}
        //super.equip(weapon);
    //}
}
