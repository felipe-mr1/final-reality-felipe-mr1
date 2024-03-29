package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class DamageTest{
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
    protected BlockingQueue<ICharacter> turns;

    @BeforeEach
    void setUp(){
        turns = new LinkedBlockingQueue<>();
        BM_Vivi = new BlackMage("Vivi", turns);
        K_Adelbert = new Knight("Adelbert", turns);
        WM_Eiko = new WhiteMage("Eiko", turns);
        E_Cid = new Engineer("Cid", turns);
        T_Zidane = new Thief("Zidane", turns);
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
        assertEquals(3.0, K_Adelbert.getDamageReceived());
        K_Adelbert.attack(Goblin);
        assertEquals(285.0, Goblin.getHealthPoints());
        Goblin.attack(BM_Vivi);
        assertNotEquals(500, BM_Vivi.getHealthPoints());
        BM_Vivi.setHealthPoints(550.0);
        BM_Vivi.equip(testStaff);
        assertNotEquals(testStaff, BM_Vivi.getEquippedWeapon());
        BM_Vivi.attack(Goblin);
        assertEquals(285.0, Goblin.getHealthPoints());
        Goblin.attack(BM_Vivi);
        K_Adelbert.attack(BM_Vivi);
        assertEquals(0.0, BM_Vivi.getHealthPoints());
    }

}
