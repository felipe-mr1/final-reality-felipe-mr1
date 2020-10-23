package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

public class Knight extends PlayerCharacter {
    public Knight(final java.lang.String name,
                    final BlockingQueue<ICharacter> turnsQueue,
                    final String characterClass){
        super(name, turnsQueue, characterClass, 800, 5);
    }
    public void equip(IWeapon weapon) {
        weapon.equip(this);
    }

    //@Override
    //public void equipKnife(Knife knife){super.equipKnife(knife);}

    //@Override
    //public void equipSword(Sword sword) {super.equipSword(sword);}

    //@Override
    //public void equipAxe(Axe axe){super.equipAxe(axe);}

}
