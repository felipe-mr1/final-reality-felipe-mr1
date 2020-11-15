package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.*;

public interface IPlayer {


    void equip(IWeapon weapon);

    IWeapon getEquippedWeapon();

    void equipAxe(Axe axe);

    void equipBow(Bow bow);

    void equipKnife(Knife knife);

    void equipStaff(Staff staff);

    void equipSword(Sword sword);


}
