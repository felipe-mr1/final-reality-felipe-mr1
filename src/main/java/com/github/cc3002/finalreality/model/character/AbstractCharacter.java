package com.github.cc3002.finalreality.model.character;
import com.github.cc3002.finalreality.model.Controller.ControllerFF;
import com.github.cc3002.finalreality.model.weapon.*;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;


/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private final String characterClass;
  protected ScheduledExecutorService scheduledExecutor;
  private double healthPoints;
  private final int defensePoints;
  private IWeapon equippedWeapon = null;
  private double damageReceived = 0;
  private PropertyChangeSupport changes;

  protected AbstractCharacter( BlockingQueue<ICharacter> turnsQueue,
                               String name, String characterClass, double healthPoints, int defensePoints) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.healthPoints = healthPoints;
    this.defensePoints = defensePoints;
    this.changes = new PropertyChangeSupport(this);
  }


  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
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
    damageReceived = value;
    if (this.healthPoints <= 0){
      changes.firePropertyChange("Out of combat", "", getName());
      this.healthPoints = 0;

    }
  }

  @Override
  public int getDefensePoints(){return this.defensePoints;}

  @Override
  public IWeapon getEquippedWeapon(){return this.equippedWeapon;}

  @Override
  public double getDamageReceived(){return this.damageReceived;}

  @Override
  public void connect(ControllerFF controllerFF){
    changes.addPropertyChangeListener(controllerFF);
  }
}
