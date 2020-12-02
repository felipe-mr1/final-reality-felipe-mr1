package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.*;

public interface IPlayer {

    /**
     *
     * @param weapon to equip
     * Sends a message to equip the given weapon
     * to the Character
     */
    void equip(IWeapon weapon);

    IWeapon getEquippedWeapon();

    void equipAxe(Axe axe);

    void equipBow(Bow bow);

    void equipKnife(Knife knife);

    void equipStaff(Staff staff);

    void equipSword(Sword sword);

    void inventory(IWeapon weapon);
}
