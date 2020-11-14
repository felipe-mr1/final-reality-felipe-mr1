package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;

import java.util.concurrent.BlockingQueue;

public class WhiteMage extends PlayerCharacter {
    double mana;
    public WhiteMage(final java.lang.String name,
                     final BlockingQueue<ICharacter> turnsQueue,
                     final String characterClass) {
        super(name, turnsQueue, characterClass, 500, 1);
        this.mana = 200;
    }

    public void equip(IWeapon weapon) {
        weapon.equip(this);
    }

    @Override
    public void equipStaff(Staff staff){super.equip(staff);}

}
