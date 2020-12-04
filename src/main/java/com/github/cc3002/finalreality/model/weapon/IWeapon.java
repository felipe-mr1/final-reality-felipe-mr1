package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

/**
 * This represents a weapon from the game.
 * Only playable characters are able to equip weapons.
 */
public interface IWeapon {
    /**
     *
     * @param weapon of the player
     * @return True if these two weapons are the same.
     */
    boolean equals(Object weapon);

    /**
     *
     * @return the name of the weapon.
     */
    String getName();

    /**
     *
     * @return the damage of the weapon.
     */
    int getDamage();

    /**
     *
     * @return the magic damage of the weapon.
     */
    int getMagicDamage();

    /**
     *
     * @return the weight of the weapon.
     */
    int getWeight();


    /**
     *
     * @param character
     * character to equip the weapon
     *
     * Checks if the character can equip the weapon.
     */
    void equip(IPlayer character);

    /**
     * Sends a message to readjust the health points
     * of a character
     * @param target
     */
    void attack(ICharacter target);

    /**
     * Used to get the type of the weapon
     * @return type of the weapon
     */
    String getType();
}
