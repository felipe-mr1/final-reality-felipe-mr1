package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnemyTest extends AbstractCharacterTest {

  private static final java.lang.String ENEMY_NAME = "Goblin";

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, 10, turns));
  }

  @Test
  void constructorTest() {
    Enemy goblin = new Enemy("goblin", 15, turns);
    Enemy orco = new Enemy("orco", 25, turns);
    Enemy goblin2 = new Enemy("goblin", 20,turns);
    Engineer engi = new Engineer("engi", turns, "Engineer");
    assertFalse(goblin.equals(orco));
    assertFalse(goblin.equals(engi));
    assertNotEquals(goblin.hashCode(), engi.hashCode());
    assertFalse(goblin.equals(goblin2));


    checkConstruction(new Enemy(ENEMY_NAME, 10, turns),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, 11, turns),
        new PlayerCharacter(ENEMY_NAME, turns, "String.THIEF", 10));
  }
}