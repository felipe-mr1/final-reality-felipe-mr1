package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;



import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    Enemy enemy = new Enemy("Enemy", 10, turns);
    assertNotEquals(BM_Vivi, enemy);
    assertNotEquals(BM_Vivi, K_Adelbert);
    assertFalse(BM_Vivi.equals(K_Adelbert));
    assertEquals("Vivi", BM_Vivi.getName());
    assertNotEquals(BM_Vivi.hashCode(), K_Adelbert.hashCode());
  }

  @Test
  void equipWeaponTest(){
    assertNull(BM_Vivi.getEquippedWeapon());
    assertNull(K_Adelbert.getEquippedWeapon());
    assertNull(WM_Eiko.getEquippedWeapon());
    assertNull(E_Cid.getEquippedWeapon());
    assertNull(T_Zidane.getEquippedWeapon());
    BM_Vivi.equip(testKnife);
    assertEquals(testKnife, BM_Vivi.getEquippedWeapon());
    K_Adelbert.equip(testSword);
    assertEquals(testSword, K_Adelbert.getEquippedWeapon());
    WM_Eiko.equip(testStaff);
    assertEquals(testStaff, WM_Eiko.getEquippedWeapon());
    E_Cid.equip(testAxe);
    assertEquals(testAxe, E_Cid.getEquippedWeapon());
    T_Zidane.equip(testBow);
    assertEquals(testBow, T_Zidane.getEquippedWeapon());
    T_Zidane.equip(testSword); // branches
    assertEquals(testSword, T_Zidane.getEquippedWeapon());
    BM_Vivi.equip(testStaff);
    assertEquals(testStaff, BM_Vivi.getEquippedWeapon());
    E_Cid.equip(testKnife);
    assertEquals(testKnife, E_Cid.getEquippedWeapon());
    T_Zidane.equip(testStaff);
    assertEquals(testStaff, T_Zidane.getEquippedWeapon());
    K_Adelbert.equip(testBow);
    assertEquals(testBow, K_Adelbert.getEquippedWeapon());
    E_Cid.equip(testSword);
    assertEquals(testSword, E_Cid.getEquippedWeapon());
    E_Cid.equip(testBow);
    assertEquals(testBow, E_Cid.getEquippedWeapon());
    K_Adelbert.equip(testKnife);
    assertEquals(testKnife, K_Adelbert.getEquippedWeapon());
    K_Adelbert.equip(testAxe);
    assertEquals(testAxe, K_Adelbert.getEquippedWeapon());
  }
}
