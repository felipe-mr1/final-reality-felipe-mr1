package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;
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

  /**
   * Sends a message to equip a weapon
   * @param weapon to equip
   */
  void equip(IWeapon weapon);

  /**
   * Sends a message to attack a given character.
   * This character can be a player or an enemy
   * @param character to attack
   */
  void attack(ICharacter character);

  /**
   * Gets the defense points of this character
   * @return defense points
   */
  int getDefensePoints();


  /**
   * method to get the weapon that a character is using
   * @return the equipped weapon
   */
  IWeapon getEquippedWeapon();

  /**
   * method to get the value of the last attack that
   * the character received
   * @return damage received
   */
  double getDamageReceived();

  /**
   * connects the observable character with the controller(Listener)
   * @param controllerFF
   */
  void connect(ControllerFF controllerFF);
}
