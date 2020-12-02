package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Your name>
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  protected ScheduledExecutorService scheduledExecutor;


  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final java.lang.String name, final int weight,
               @NotNull final BlockingQueue<ICharacter> turnsQueue) {
    super(turnsQueue, name, "Enemy", 300, 0);
    this.weight = weight;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, this.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public void attack(ICharacter character) {
    Random rng = new Random();
    if (character.getHealthPoints()>0) {
      character.setHealthPoints(20);
    }
  }

  @Override
  public int getDefensePoints() {
    return 0;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }
}
