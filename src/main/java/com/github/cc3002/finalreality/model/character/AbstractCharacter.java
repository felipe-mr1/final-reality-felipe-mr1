package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.*;

import java.util.Observable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractCharacter extends Observable implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final java.lang.String name;
  private final String characterClass;
  protected ScheduledExecutorService scheduledExecutor;
  private double healthPoints;
  private final int defensePoints;
  private IWeapon equippedWeapon = null;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull java.lang.String name, String characterClass, double healthPoints, int defensePoints) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.healthPoints = healthPoints;
    this.defensePoints = defensePoints;
  }


  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public java.lang.String getName() {
    return name;
  }

  public void equip(IWeapon weapon){this.equippedWeapon = weapon;}


  @Override
  public String getCharacterClass() {
    return characterClass;
  }

  @Override
  public double getHealthPoints() {return healthPoints;}

  @Override
  public void setHealthPoints(double value) {
    this.healthPoints = this.healthPoints - value;
    if (this.healthPoints <= 0){
      setChanged();
      this.healthPoints = 0;
      notifyObservers(this);
    }
  }

  @Override
  public int getDefensePoints(){return this.defensePoints;}

  public IWeapon getEquippedWeapon(){return this.equippedWeapon;}
}
