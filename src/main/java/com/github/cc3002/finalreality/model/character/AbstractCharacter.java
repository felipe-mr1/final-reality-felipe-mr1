package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final java.lang.String name;
  private final String characterClass;
  private IWeapon equippedWeapon = null;
  private ScheduledExecutorService scheduledExecutor;
  private double healthPoints;
  private final int defensePoints;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull java.lang.String name, String characterClass, double healthPoints, int defensePoints) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.healthPoints = healthPoints;
    this.defensePoints = defensePoints;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof PlayerCharacter) {
      scheduledExecutor
          .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    } else {
      var enemy = (Enemy) this;
      scheduledExecutor
          .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
    }
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public java.lang.String getName() {
    return name;
  }

  @Override
  public void equip(IWeapon weapon) {
    if ((this instanceof PlayerCharacter)&&(this.getHealthPoints()>0)) {
      this.equippedWeapon = weapon;
    }
  }

  @Override
  public void equipStaff(Staff weapon){}

  @Override
  public void equipAxe(Axe weapon){}

  @Override
  public void equipBow(Bow weapon){}

  @Override
  public void equipKnife(Knife weapon){}

  @Override
  public void equipSword(Sword weapon){}

  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public String getCharacterClass() {
    return characterClass;
  }

  @Override
  public double getHealthPoints() {return healthPoints;}

  @Override
  public void setHealthPoints(double value) {this.healthPoints = this.healthPoints - value;}

  public void attack(ICharacter character){getEquippedWeapon().attack(character);}

  public int getDefensePoints(){return this.defensePoints;}
}
