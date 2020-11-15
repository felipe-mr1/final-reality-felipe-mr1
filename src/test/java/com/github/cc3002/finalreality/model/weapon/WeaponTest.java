package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int SPEED = 10;
  private static final int MagicDamage = 15;

  private IWeapon testAxe;
  private IWeapon testStaff;
  private IWeapon testSword;
  private IWeapon testBow;
  private IWeapon testKnife;

  /**
   * Setup method.
   * Creates 5 tests weapons.
   */
  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, SPEED, "Axe");
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, "Staff", MagicDamage);
    testSword = new Sword(SWORD_NAME, DAMAGE, SPEED, "Sword");
    testBow = new Bow(BOW_NAME, DAMAGE, SPEED, "Bow");
    testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED, "Knife");
  }

  /**
   * Checks the constructor method and sees if we are dealing with 2 different objects.
   */
  @Test
  void constructorTest() {
    var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED, "Axe");
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, "Staff", MagicDamage);
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED, "Sword");
    var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED, "Bow");
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED, "Knife");
    var expectedKnife2= new Knife("Knife2",15, 10, "Knife");

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedSword, testSword);
    assertEquals(expectedBow, testBow);
    assertEquals(expectedKnife, testKnife);
    assertNotEquals(expectedBow, testAxe);
    assertNotEquals(expectedAxe, testStaff);
    assertNotEquals(expectedAxe, testSword);
    assertNotEquals(expectedAxe, testBow);
    assertNotEquals(expectedAxe, testKnife);
    assertNotEquals(expectedKnife2, testKnife);
  }

  /**
   * Checks if we can get attributes of the weapons.
   */
  @Test
  void attributesTest(){
    assertEquals(15, testAxe.getDamage());
    assertEquals(10, testAxe.getWeight());
    assertEquals(0,testAxe.getMagicDamage());

  }
}