package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

public class Thief extends AbstractPlayerCharacter {
    int defensePoints;
    public Thief(final String name,
                    final BlockingQueue<ICharacter> turnsQueue){
        super(name, turnsQueue, "Thief", 600, 2);
        this.defensePoints = 100;
    }
    public void equip(IWeapon weapon) {
        weapon.equip(this);
    }

    @Override
    public void equipStaff(Staff staff){super.equip(staff);}

    @Override
    public void equipSword(Sword sword){super.equip(sword);}

    @Override
    public void equipBow(Bow bow){super.equip(bow);}

}
