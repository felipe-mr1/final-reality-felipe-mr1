package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

public class Knight extends PlayerCharacter {
    int healthPoints;
    int defensePoints;
    public Knight(final java.lang.String name,
                    final BlockingQueue<ICharacter> turnsQueue,
                    final String characterClass){
        super(name, turnsQueue, characterClass);
        this.healthPoints = 800;
        this.defensePoints = 250;
    }
    public void equip(IWeapon weapon) throws Exception {
        if (!(weapon instanceof Axe | weapon instanceof Knife | weapon instanceof Sword)){
            throw new Exception("Can't equip that type of weapon");
        }
        super.equip(weapon);
    }
}
