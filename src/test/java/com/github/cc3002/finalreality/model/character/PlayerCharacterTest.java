package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;



import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see AbstractPlayerCharacter
 */
class PlayerCharacterTest extends AbstractCharacterTest  {

  BlackMage BM_Vivi;
  BlackMage BM_Viviana;
  Knight K_Adelbert;
  WhiteMage WM_Eiko;
  Engineer E_Cid;
  Thief T_Zidane;
  BlackMage BM_Perrito;
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
    turns = new LinkedBlockingQueue<>();
    super.basicSetUp();
    BM_Vivi = new BlackMage("Vivi", turns);
    BM_Viviana = new BlackMage("Vivi", turns);
    BM_Perrito = new BlackMage("Perrito", turns);
    K_Adelbert = new Knight("Adelbert", turns);
    WM_Eiko = new WhiteMage("Eiko", turns);
    E_Cid = new Engineer("Cid", turns);
    T_Zidane = new Thief("Zidane", turns);
    testCharacters.add(BM_Vivi);
    //testCharacters.add(K_Adelbert);
    //testCharacters.add(WM_Eiko);
    //testCharacters.add(E_Cid);
    //testCharacters.add(T_Zidane);
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
    assertNotEquals(K_Adelbert, BM_Vivi);
    assertNotEquals(BM_Perrito, BM_Vivi);
    assertEquals("Vivi", BM_Vivi.getName());
    assertNotEquals(BM_Vivi.hashCode(), K_Adelbert.hashCode());
    assertEquals(BM_Vivi, BM_Viviana);
  }

  /**
   * Checks if the character equipped the weapon.
   */
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
    T_Zidane.equip(testStaff);
    assertEquals(testStaff, T_Zidane.getEquippedWeapon());
    E_Cid.equip(testBow);
    assertEquals(testBow, E_Cid.getEquippedWeapon());
    K_Adelbert.equip(testKnife);
    assertEquals(testKnife, K_Adelbert.getEquippedWeapon());
    K_Adelbert.equip(testAxe);
    assertEquals(testAxe, K_Adelbert.getEquippedWeapon());
  }

  /**
   * Checking the 'if' conditions on the method equip.
   *
   * Checks that the character didnt equip the weapon.
   */
  @Test
  void cantEquipWeaponTest(){
    E_Cid.equip(testKnife);
    assertNotEquals(testKnife, E_Cid.getEquippedWeapon());
    K_Adelbert.equip(testBow);
    assertNotEquals(testBow, K_Adelbert.getEquippedWeapon());
    E_Cid.equip(testSword);
    assertNotEquals(testSword, E_Cid.getEquippedWeapon());
  }

  /**
   * Checks if the attributes of the characters are
   * well settled.
   */
  @Test
  void attributesTest(){
    assertEquals(500, BM_Vivi.getHealthPoints());
    BM_Vivi.setHealthPoints(50);
    assertEquals(450,BM_Vivi.getHealthPoints());
    BM_Vivi.setHealthPoints(500);
    assertEquals(0, BM_Vivi.getHealthPoints());
  }
}
