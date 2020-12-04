package com.github.cc3002.finalreality.model.Controller;


import com.github.cc3002.finalreality.model.Client.ControllerFF;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class ControllerTest {

    ControllerFF controllerFF;

    @BeforeEach
    public void setUp(){
        controllerFF = new ControllerFF();
        controllerFF.createPlayer("Libano", "Black Mage");
        controllerFF.createPlayer("Siberia", "White Mage");
        controllerFF.createPlayer("Chile", "Thief");
        controllerFF.createPlayer("Bolivia", "Knight");
        controllerFF.createPlayer("Peru", "Engineer");
        controllerFF.createWeapon("baston", 10, 50, "Staff", 25);
        controllerFF.createWeapon("baston blanco", 5, 55, "Staff", 20);
        controllerFF.createWeapon("Espada Maestra", 300, 60, "Sword", 0);
        controllerFF.createWeapon("Espada", 30, 62, "Sword", 0);
        controllerFF.createWeapon("Hacha", 35, 57, "Axe", 0);
        controllerFF.createWeapon("Ballesta", 15, 66, "Bow", 0);
        controllerFF.createEnemy("Enemy0", 15);
    }

    @Test
    public void controllerConstructorTest(){
        assertEquals("Black Mage", controllerFF.getPlayer("Libano").getCharacterClass());
        assertEquals("Staff", controllerFF.getWeapon("baston").getType());
    }

    @Test
    public void controllerTurnsTest() throws InterruptedException {
        controllerFF.equip("Libano", "baston");
        controllerFF.equip("Siberia", "baston blanco");
        controllerFF.equip("Chile", "Espada");
        controllerFF.equip("Bolivia", "Hacha");
        controllerFF.equip("Peru", "Ballesta");
        controllerFF.addToQueue();
        var expected = controllerFF.getTurn();
        var actual = controllerFF.getTurn();
        assertNotEquals(controllerFF.getTurn(), controllerFF.getTurn());
    }

    @Test
    public void controllerInventoryTest(){
        controllerFF.inventory(new PrintStream(OutputStream.nullOutputStream()));
        assertEquals("baston", controllerFF.getWeapon("baston").getName());
    }

    @Test
    public void controllerGameOverTest(){
        controllerFF.equip("Chile", "Espada Maestra");
        controllerFF.attack("Chile", "Enemy0");
        assertTrue(controllerFF.gameOver());
    }

    @Test
    public void controllerNotGameOver(){
        controllerFF.equip("Libano", "baston");
        controllerFF.attack("Libano", "Enemy0");
        assertFalse(controllerFF.gameOver());
    }

    @Test
    public void controllerAttackTest() throws InterruptedException {
        controllerFF.getEnemiesHealthPoints(new PrintStream(OutputStream.nullOutputStream()));
        controllerFF.getPlayersHealthPoints(new PrintStream(OutputStream.nullOutputStream()));
        controllerFF.equip("Libano", "baston");
        controllerFF.equip("Siberia", "baston blanco");
        controllerFF.equip("Chile", "Espada");
        controllerFF.equip("Bolivia", "Hacha");
        controllerFF.equip("Peru", "Ballesta");
        controllerFF.addToQueue();
        //var character = controllerFF.getTurn();
        assertFalse(controllerFF.playersDead());
    }

}
