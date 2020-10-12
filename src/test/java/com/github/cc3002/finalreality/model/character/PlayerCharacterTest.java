package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.*;

import java.util.Map;

import com.github.cc3002.finalreality.model.weapon.*;
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

  BlackMage BM_Vivi;
  Knight K_Adelbert;
  WhiteMage WM_Eiko;
  Engineer E_Cid;
  Thief T_Zidane;
  Sword testSword;
  Staff testStaff;
  Axe testAxe;
  Bow testBow;
  Knife testKnife;
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
    super.basicSetUp();
    BM_Vivi = new BlackMage("Vivi", turns, "Black Mage");
    K_Adelbert = new Knight("Adelbert", turns, "Knight");
    WM_Eiko = new WhiteMage("Eiko", turns, "White Mage");
    E_Cid = new Engineer("Cid", turns, "Engineer");
    T_Zidane = new Thief("Zidane", turns, "Thief");
    testCharacters.add(BM_Vivi);
    testCharacters.add(K_Adelbert);
    testCharacters.add(WM_Eiko);
    testCharacters.add(E_Cid);
    testCharacters.add(T_Zidane);
    testAxe = new Axe("Axe", 15, 10, "Axe");
    testStaff = new Staff("Staff", 5, 15, "Staff",20);
    testSword = new Sword("Sword", 15, 10, "Sword");
    testBow = new Bow("Bow", 12, 8, "Bow");
    testKnife = new Knife("Knife", 8, 4, "Knife");
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
    Enemy enemy = new Enemy("Enemy", 10, turns);
    assertNotEquals(BM_Vivi, enemy);
    assertNotEquals(BM_Vivi, K_Adelbert);
    BM_Vivi.equals(K_Adelbert);
    BM_Vivi.getName();
  }

  @Test
  void equipWeaponTest() throws Exception {
    assertNull(BM_Vivi.getEquippedWeapon());
    assertNull(K_Adelbert.getEquippedWeapon());
    assertNull(WM_Eiko.getEquippedWeapon());
    assertNull(E_Cid.getEquippedWeapon());
    assertNull(T_Zidane.getEquippedWeapon());
    BM_Vivi.equip(testKnife);
    K_Adelbert.equip(testSword);
    WM_Eiko.equip(testStaff);
    E_Cid.equip(testAxe);
    T_Zidane.equip(testBow);
    T_Zidane.equip(testSword); // branches
    BM_Vivi.equip(testStaff);
    E_Cid.equip(testKnife);
    T_Zidane.equip(testStaff);
    K_Adelbert.equip(testBow);
    E_Cid.equip(testSword);
    E_Cid.equip(testBow);
    K_Adelbert.equip(testKnife);
    K_Adelbert.equip(testAxe);
  }
}
