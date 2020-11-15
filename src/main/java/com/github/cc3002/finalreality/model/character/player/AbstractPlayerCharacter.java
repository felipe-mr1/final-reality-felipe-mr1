package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements com.github.cc3002.finalreality.model.character.player.IPlayer {

  protected IWeapon equippedWeapon = null;
  //private ScheduledExecutorService scheduledExecutor;


  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   */
  public AbstractPlayerCharacter(@NotNull java.lang.String name,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                                 final String characterClass, double healthPoints, int defensePoints) {
    super(turnsQueue, name, characterClass, healthPoints, defensePoints);
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  public IWeapon getEquippedWeapon(){
    return equippedWeapon;
  }

  public void equip(IWeapon weapon){
    if (getHealthPoints() >0){
      this.equippedWeapon = weapon;
    }
  }
  @Override
  public void equipAxe(Axe axe){}

  @Override
  public void equipBow(Bow bow){}

  @Override
  public void equipKnife(Knife knife){}

  @Override
  public void equipStaff(Staff staff){}

  @Override
  public void equipSword(Sword sword){}

  @Override
  public void attack(ICharacter character){
    if (this.getHealthPoints()>0) {
      getEquippedWeapon().attack(character);
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getCharacterClass()) + Objects.hash(this.name);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractPlayerCharacter)) {
      return false;
    }
    final AbstractPlayerCharacter that = (AbstractPlayerCharacter) o;
    return getCharacterClass().equals(that.getCharacterClass())
        && getName().equals(that.getName());
  }
}
