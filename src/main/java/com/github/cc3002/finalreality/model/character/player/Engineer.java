package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

public class Engineer extends PlayerCharacter {
    int healthPoints;
    int defensePoints;
    public Engineer(final java.lang.String name,
                     final BlockingQueue<ICharacter> turnsQueue,
                     final String characterClass){
        super(name, turnsQueue, characterClass);
        this.healthPoints = 600;
        this.defensePoints = 150;
    }
    public void equip(IWeapon weapon) throws Exception {
        if (!(weapon instanceof Axe | weapon instanceof Bow)){
            throw new Exception("Can't equip that type of weapon");
        }
        super.equip(weapon);
    }
}
