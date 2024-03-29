package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Staff;

import java.util.concurrent.BlockingQueue;

public class BlackMage extends AbstractPlayerCharacter {

    int mana;
    public BlackMage(final String name,
                     final BlockingQueue<ICharacter> turnsQueue){
        super(name, turnsQueue, "Black Mage", 500, 2);
        this.mana = 200;
    }


    public void equip(IWeapon weapon) {
        weapon.equip(this);
    }

    @Override
    public void equipStaff(Staff staff) {super.equip(staff);}

    @Override
    public void equipKnife(Knife knife) {super.equip(knife);}

}
