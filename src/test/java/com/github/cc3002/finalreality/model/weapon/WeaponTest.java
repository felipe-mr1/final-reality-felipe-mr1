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

  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, SPEED, "Axe");
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, "Staff", MagicDamage);
    testSword = new Sword(SWORD_NAME, DAMAGE, SPEED, "Sword");
    testBow = new Bow(BOW_NAME, DAMAGE, SPEED, "Bow");
    testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED, "Knife");
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED, "Axe");
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, "Staff", MagicDamage);
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED, "Sword");
    var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED, "Bow");
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED, "Knife");
    var expectedKnife2= new Knife("Knife2",15, 10, "Knife");

    assertTrue(testAxe.equals(expectedAxe));
    assertTrue(testStaff.equals(expectedStaff));
    assertTrue(testSword.equals(expectedSword));
    assertTrue(testBow.equals(expectedBow));
    assertTrue(testKnife.equals(expectedKnife));
    assertFalse(testAxe.equals(expectedBow));
    assertFalse(testStaff.equals(expectedAxe));
    assertFalse(testSword.equals(expectedAxe));
    assertFalse(testBow.equals(expectedAxe));
    assertFalse(testKnife.equals(expectedAxe));
    assertFalse(testKnife.equals(expectedKnife2));
  }

  @Test
  void attributesTest(){
    assertEquals(15, testAxe.getDamage());
    assertEquals(10, testAxe.getWeight());
    assertEquals(0,testAxe.getMagicDamage());

  }
}