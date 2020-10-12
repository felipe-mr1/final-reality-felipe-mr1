package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnemyTest extends AbstractCharacterTest {

  private static final java.lang.String ENEMY_NAME = "Goblin";

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, 10, turns));
  }

  @Test
  void constructorTest() {
    Enemy golbin = new Enemy("goblin", 15, turns);
    Enemy orco = new Enemy("orco", 25, turns);
    Enemy goblin2 = new Enemy("goblin", 15,turns);
    Engineer engi = new Engineer("engi", turns, "Engineer");
    golbin.equals(orco);
    golbin.equals(engi);
    golbin.hashCode();
    golbin.equals(goblin2);

    //checkConstruction(new Enemy(ENEMY_NAME, 10, turns),
        //testCharacters.get(0),
        //new Enemy(ENEMY_NAME, 11, turns),
        //new PlayerCharacter(ENEMY_NAME, turns, "String.THIEF"));
  }
}