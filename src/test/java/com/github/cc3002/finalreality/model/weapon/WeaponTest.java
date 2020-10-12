package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    testAxe.equals(expectedAxe);
    testStaff.equals(expectedStaff);
    testSword.equals(expectedSword);
    testBow.equals(expectedBow);
    testKnife.equals(expectedKnife);
    testAxe.equals(expectedBow);
    testStaff.equals(expectedAxe);
    testSword.equals(expectedAxe);
    testBow.equals(expectedAxe);
    testKnife.equals(expectedAxe);
    testKnife.equals(expectedKnife2);
  }

  @Test
  void attributesTest(){
    testAxe.getDamage();
    testAxe.getWeight();
    testAxe.getMagicDamage();

  }
}