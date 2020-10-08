package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.*;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see PlayerCharacter
 */
class PlayerCharacterTest extends AbstractCharacterTest {

  private static final java.lang.String BLACK_MAGE_NAME = "Vivi";
  private static final java.lang.String KNIGHT_NAME = "Adelbert";
  private static final java.lang.String WHITE_MAGE_NAME = "Eiko";
  private static final java.lang.String ENGINEER_NAME = "Cid";
  private static final java.lang.String THIEF_NAME = "Zidane";
  private Map<String, java.lang.String> characterNames;

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    BlackMage BM_Vivi = new BlackMage("Vivi", turns, "Black Mage");
    Knight K_Adelbert = new Knight("Adelbert", turns, "Knight");
    WhiteMage WM_Eiko = new WhiteMage("Eiko", turns, "White Mage");
    Engineer E_Cid = new Engineer("Cid", turns, "Engineer");
    Thief T_Zidane = new Thief("Zidane", turns, "Thief");
    //super.basicSetUp();

    //characterNames = new EnumMap<>(String.class);
    //characterNames.put(String.BLACK_MAGE, BLACK_MAGE_NAME);
    //characterNames.put(String.KNIGHT, KNIGHT_NAME);
    //characterNames.put(String.WHITE_MAGE, WHITE_MAGE_NAME);
    //characterNames.put(String.ENGINEER, ENGINEER_NAME);
    //characterNames.put(String.THIEF, THIEF_NAME);

    //for (var characterClass :
        //characterNames.keySet()) {
      //testCharacters.add(
          //new PlayerCharacter(characterNames.get(characterClass), turns, characterClass));
    //}
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var enemy = new Enemy("Enemy", 10, turns);
    for (var character :
        testCharacters) {
      var characterClass = character.getCharacterClass();
      var characterName = characterNames.get(characterClass);
      checkConstruction(new PlayerCharacter(characterName, turns, characterClass),
          character,
          new PlayerCharacter("Test", turns, characterClass),
          new PlayerCharacter(characterName, turns,
              characterClass == String.THIEF ? String.BLACK_MAGE
                  : String.THIEF));
      assertNotEquals(character, enemy);
    }

  }

  @Test
  void equipWeaponTest() {
    for (var character :
        testCharacters) {
      assertNull(character.getEquippedWeapon());
      character.equip(testWeapon);
      assertEquals(testWeapon, character.getEquippedWeapon());
    }
  }
}
