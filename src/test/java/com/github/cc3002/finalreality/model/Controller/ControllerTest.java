package com.github.cc3002.finalreality.model.Controller;


import com.github.cc3002.finalreality.model.Controller.Phases.AttackPhase;
import com.github.cc3002.finalreality.model.Controller.Phases.CreationPhase;
import com.github.cc3002.finalreality.model.Controller.Phases.InvalidActionException;
import com.github.cc3002.finalreality.model.Controller.Phases.InventoryPhase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



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
        controllerFF.createWeapon("cuchiullo", 30, 52, "Knife", 0);
        controllerFF.createEnemy("Enemy0", 15);

    }

    @Test
    public void controllerConstructorTest(){
        assertEquals("Black Mage", controllerFF.getPlayer("Libano").getCharacterClass());
        assertEquals("Staff", controllerFF.getWeapon("baston").getType());
        assertEquals("Espada", controllerFF.getWeapon("Espada").getName());
        controllerFF.createEnemies();
        assertEquals("Goblin0", controllerFF.getEnemy("Goblin0").getName());
        assertEquals(5, controllerFF.partySize());

    }

    @Test
    public void controllerTurnsTest() throws InterruptedException {
        controllerFF.equip("Libano", "baston");
        controllerFF.equip("Siberia", "baston blanco");
        controllerFF.equip("Chile", "Espada");
        controllerFF.equip("Bolivia", "Hacha");
        controllerFF.equip("Peru", "Ballesta");
        controllerFF.addToQueue();
        assertNotEquals(controllerFF.getTurn(), controllerFF.getTurn());
    }

    @Test
    public void controllerInventoryTest(){
        assertEquals("Name: baston || Type: Staff || Damage: 10 || Magic Damage: 25 || Weight: 50 \n\n" +
                "Name: baston blanco || Type: Staff || Damage: 5 || Magic Damage: 20 || Weight: 55 \n\n" +
                "Name: Espada Maestra || Type: Sword || Damage: 300 || Magic Damage: 0 || Weight: 60 \n\n" +
                "Name: Espada || Type: Sword || Damage: 30 || Magic Damage: 0 || Weight: 62 \n\n" +
                "Name: Hacha || Type: Axe || Damage: 35 || Magic Damage: 0 || Weight: 57 \n\n" +
                "Name: Ballesta || Type: Bow || Damage: 15 || Magic Damage: 0 || Weight: 66 \n\n" +
                "Name: cuchiullo || Type: Knife || Damage: 30 || Magic Damage: 0 || Weight: 52 \n\n",controllerFF.inventory());
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
        //controllerFF.getEnemiesHealthPoints(new PrintStream(OutputStream.nullOutputStream()));
        //controllerFF.getPlayersHealthPoints(new PrintStream(OutputStream.nullOutputStream()));
        controllerFF.equip("Libano", "baston");
        controllerFF.equip("Siberia", "baston blanco");
        controllerFF.equip("Chile", "Espada");
        controllerFF.equip("Bolivia", "Hacha");
        controllerFF.equip("Peru", "Ballesta");
        controllerFF.addToQueue();
        assertFalse(controllerFF.playersDead());
    }

    @Test
    public void controllerNullTest(){
        controllerFF.createPlayer("asd", "Whie MAAge");
        controllerFF.createWeapon("RRRR", 123, 44, "Kifeee", 0);
        assertNull(controllerFF.getWeapon("RRRR"));
        assertNull(controllerFF.getPlayer("asd"));
        assertNull(controllerFF.getEnemy("asdf"));
        assertEquals("", controllerFF.getTurnOf());
        assertEquals("Enemy0  HP[300.0]    ", controllerFF.getEnemies());
    }

    @Test
    public void controllerPlayersDeadTest(){
        controllerFF.getPlayer("Libano").setHealthPoints(500);
        controllerFF.getPlayer("Siberia").setHealthPoints(500);
        controllerFF.getPlayer("Chile").setHealthPoints(600);
        controllerFF.getPlayer("Bolivia").setHealthPoints(800);
        controllerFF.getPlayer("Peru").setHealthPoints(600);
        assertTrue(controllerFF.playersDead());
        assertTrue(controllerFF.gameOver());
    }

    @Test
    public void infoTest() throws InterruptedException {
        controllerFF.equip("Libano", "baston");
        controllerFF.equip("Siberia", "baston blanco");
        controllerFF.equip("Chile", "Espada");
        controllerFF.equip("Bolivia", "Hacha");
        controllerFF.equip("Peru", "Ballesta");
        controllerFF.addToQueue();
        assertEquals(1, controllerFF.enemySize());
        assertEquals(" Libano Siberia Chile Bolivia Peru ", controllerFF.getParty());
        assertEquals("Libano  HP[500.0]   Siberia  HP[500.0]   Chile  HP[600.0]   Bolivia  HP[800.0]   Peru  HP[600.0]   ", controllerFF.getPartyInfo());
        assertEquals("Libano--- Class: Black Mage--- Defense Points:2--- Equipped Weaponbaston[Staff]\n" +
                "\n" +
                "Siberia--- Class: White Mage--- Defense Points:1--- Equipped Weaponbaston blanco[Staff]\n" +
                "\n" +
                "Chile--- Class: Thief--- Defense Points:2--- Equipped WeaponEspada[Sword]\n" +
                "\n" +
                "Bolivia--- Class: Knight--- Defense Points:5--- Equipped WeaponHacha[Axe]\n" +
                "\n" +
                "Peru--- Class: Engineer--- Defense Points:3--- Equipped WeaponBallesta[Bow]\n" +
                "\n", controllerFF.getBattleInfo());
        assertEquals("Enemy0", controllerFF.getTurnOf());

    }

    @Test
    public void phasesTest() throws InvalidActionException {
        controllerFF.setPhase(new InventoryPhase(controllerFF));
        controllerFF.tryToEquip("Chile", "Espada");
        controllerFF.setPhase(new AttackPhase(controllerFF));
        controllerFF.tryToAttack("Chile", "Enemy0");
        assertNotEquals(300, controllerFF.getEnemy("Enemy0").getHealthPoints());
        ControllerFF controllerFF1 = new ControllerFF();
        controllerFF1.setPhase(new CreationPhase(controllerFF1));
        controllerFF1.getPhase().tryToCreatePlayer("The Knight", "Knight", "Axe", "Wooden Axe");
        assertEquals("Wooden Axe", controllerFF1.getPlayer("The Knight").getEquippedWeapon().getName());

    }
}
