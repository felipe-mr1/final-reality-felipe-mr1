package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DamageTest extends AbstractCharacterTest{
    BlackMage BM_Vivi;
    Knight K_Adelbert;
    WhiteMage WM_Eiko;
    Engineer E_Cid;
    Thief T_Zidane;
    Enemy Goblin;
    Sword testSword;
    Staff testStaff;
    Axe testAxe;
    Bow testBow;
    Knife testKnife;

    @BeforeEach
    void setUp(){
        super.basicSetUp();
        BM_Vivi = new BlackMage("Vivi", turns, "Black Mage");
        testCharacters.add(BM_Vivi);
        K_Adelbert = new Knight("Adelbert", turns, "Knight");
        WM_Eiko = new WhiteMage("Eiko", turns, "White Mage");
        E_Cid = new Engineer("Cid", turns, "Engineer");
        T_Zidane = new Thief("Zidane", turns, "Thief");
        Goblin = new Enemy("Goblin", 15, turns);
        testAxe = new Axe("Axe", 15, 10, "Axe");
        testStaff = new Staff("Staff", 5, 15, "Staff",20);
        testSword = new Sword("Sword", 15, 10, "Sword");
        testBow = new Bow("Bow", 12, 8, "Bow");
        testKnife = new Knife("Knife", 8, 4, "Knife");
        BM_Vivi.equip(testKnife);
        K_Adelbert.equip(testSword);
        WM_Eiko.equip(testStaff);
        T_Zidane.equip(testBow);
        E_Cid.equip(testAxe);
    }
    @Test
    void receiveDamageTest(){
        BM_Vivi.attack(K_Adelbert);
        assertEquals(797.0, K_Adelbert.getHealthPoints());
        K_Adelbert.attack(Goblin);
        assertEquals(285.0, Goblin.getHealthPoints());
        Goblin.attack(BM_Vivi);
        assertEquals(480.0, BM_Vivi.getHealthPoints());
        BM_Vivi.setHealthPoints(500);
        BM_Vivi.equip(testStaff);
        assertNotEquals(testStaff, BM_Vivi.getEquippedWeapon());
    }

}
