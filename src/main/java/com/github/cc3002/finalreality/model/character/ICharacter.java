package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.*;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  java.lang.String getName();

  /**
   * Equips a weapon to the character.
   */
  void equip(IWeapon weapon);

  /**
   * Return this character's equipped weapon.
   */
  IWeapon getEquippedWeapon();

  /**
   * Returns this character's class.
   */
  String getCharacterClass();

  /**
   *
   * @return this character's HP
   */
  double getHealthPoints();

  /**
   *
   * @param value
   *
   * sets this character's HP according to the value.
   */
  void setHealthPoints(double value);


  void equipStaff(Staff staff);

  void equipAxe(Axe axe);

  void equipBow(Bow bow);

  void equipKnife(Knife knife);

  void equipSword(Sword sword);

  void attack(ICharacter character);

  int getDefensePoints();
}
