package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

public class Engineer extends AbstractPlayerCharacter {
    int defensePoints;
    public Engineer(final java.lang.String name,
                     final BlockingQueue<ICharacter> turnsQueue,
                     final String characterClass){
        super(name, turnsQueue, characterClass, 600, 3);
        this.defensePoints = 150;
    }
    public void equip(IWeapon weapon) {
        weapon.equip(this);
    }


    @Override
    public void equipAxe(Axe axe){super.equip(axe);}

    @Override
    public void equipBow(Bow bow){super.equip(bow);}

}
