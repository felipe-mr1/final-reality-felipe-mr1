package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

public class Knight extends AbstractPlayerCharacter {
    public Knight(final String name,
                    final BlockingQueue<ICharacter> turnsQueue){
        super(name, turnsQueue, "Knight", 800, 5);
    }
    public void equip(IWeapon weapon) {
        weapon.equip(this);
    }

    @Override
    public void equipKnife(Knife knife){super.equip(knife);}

    @Override
    public void equipSword(Sword sword) {super.equip(sword);}

    @Override
    public void equipAxe(Axe axe){super.equip(axe);}

}
