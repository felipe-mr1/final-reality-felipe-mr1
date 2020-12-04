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

    /**
     * Gets the weapon that the player is currently using
     * @return weapon from the player
     */
    IWeapon getEquippedWeapon();

    /**
     * Equips the type of weapon Axe
     * @param axe
     */
    void equipAxe(Axe axe);

    /**
     * Equips the type of weapon Bow
     * @param bow
     */
    void equipBow(Bow bow);

    /**
     * Equips the type of weapon Knife
     * @param knife
     */
    void equipKnife(Knife knife);

    /**
     * Equips the type of weapon Staff
     * @param staff
     */
    void equipStaff(Staff staff);

    /**
     * Equips the type of weapon Sword
     * @param sword
     */
    void equipSword(Sword sword);

    /**
     * Adds a weapon to the character's inventory
     * @param weapon
     */
    void inventory(IWeapon weapon);
}
