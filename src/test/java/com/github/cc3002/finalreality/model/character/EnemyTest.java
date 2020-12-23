package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EnemyTest extends AbstractCharacterTest {

  private static final java.lang.String ENEMY_NAME = "Goblin";

  /**
   * Setup method.
   * Creates a new enemy named Goblin
   */
  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, 10, turns));
  }

  /**
   * Checks that the enemies created are different from each other.
   */
  @Test
  void constructorTest() {
    Enemy goblin = new Enemy("goblin", 15, turns);
    Enemy orco = new Enemy("orco", 25, turns);
    Enemy goblin2 = new Enemy("goblin", 20,turns);
    Engineer engi = new Engineer("engi", turns);
    assertNotEquals(orco, goblin);
    assertNotEquals(engi, goblin);
    assertNotEquals(goblin.hashCode(), engi.hashCode());
    assertNotEquals(goblin2, goblin);
    assertNull(goblin.getEquippedWeapon());


    checkConstruction(new Enemy(ENEMY_NAME, 10, turns),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, 11, turns),
        new BlackMage(ENEMY_NAME, turns));
  }
}