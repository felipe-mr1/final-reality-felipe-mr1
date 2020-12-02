package com.github.cc3002.finalreality.model.Client;

import com.github.cc3002.finalreality.model.character.ICharacter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Controller {
    /*public static void main(String args[]) throws InterruptedException{
        BlockingQueue<ICharacter> queue = new LinkedBlockingQueue<>();
        GameFactory gameFactory = new GameFactory(queue);
        Random rng = new Random();
        var A= gameFactory.createPlayer("Anita", "Thief");
        var W2 = gameFactory.createWeapon("Cuchilloxd", 0, rng.nextInt(50), "Sword", 0);
        A.equip(W2);
        A.waitTurn();
        Thread.sleep(6000);
        var P = gameFactory.createPlayer("Pedro", "Black Mage");
        var W3 = gameFactory.createWeapon("Cuchillo2", 0, rng.nextInt(50), "Knife", 0);
        P.equip(W3);
        P.waitTurn();
        Thread.sleep(6000);
        var J= gameFactory.createPlayer("Juan", "Engineer");
        var D= gameFactory.createPlayer("Diego", "Knight");
        var W1 = gameFactory.createWeapon("hacha", 0, rng.nextInt(50), "Axe", 0);
        var W4 = gameFactory.createWeapon("Espada", 0, rng.nextInt(50), "Sword", 0);
        J.equip(W1);
        J.waitTurn();
        D.equip(W4);
        D.waitTurn();
        Thread.sleep(6000);
        while(!(queue.isEmpty())){
            System.out.println(queue.poll().getName());
        }
    }*/

    public static void main(String args[]) throws IOException, InterruptedException {
        BlockingQueue<ICharacter> queue = new LinkedBlockingQueue<>();
        GameFactory gameFactory = new GameFactory(queue);
        Random rng = new Random();
        int i = 0;
        while(i<4) {
            BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader characterClass = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader weaponName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader type = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Choose character's name");
                String line = name.readLine();
                System.out.println("Choose class: | Black Mage | Engineer | Knight | Thief | White Mage |");
                String line1 = characterClass.readLine();
                System.out.println("Choose name of the weapon");
                String line2 = weaponName.readLine();
                System.out.println("Choose type of the weapon: | Axe | Bow | Knife | Staff | Sword |");
                String line3 = type.readLine();
                if (line.length() == 0){break;}
                var player = gameFactory.createPlayer(line, line1);
                var weapon= gameFactory.createWeapon(line2, rng.nextInt(10)+40, rng.nextInt(50), line3, 0);
                player.equip(weapon);
                player.waitTurn();
            } catch (IOException e){

            }
            i++;
        }
        System.out.println("Creating enemies");
        Thread.sleep(6000);
        for (int j = 0; j < rng.nextInt(3) + 1; j++){
            var enemy= gameFactory.createEnemy("Enemy" + j, rng.nextInt(50));
            enemy.waitTurn();
        }
        System.out.println("Enemies created");

        while (!(gameFactory.gameOver())){
            System.out.println("Party's health points");
            gameFactory.getPlayersHealthPoints();
            System.out.println();
            System.out.println("Enemies health points");
            gameFactory.getEnemiesHealthPoints();
            System.out.println();

            var character = queue.poll();
            System.out.println("Turn of " + character.getName());
            if (character.getCharacterClass().equals("Enemy")){
                System.out.println("Enemy turn");
                var target1=gameFactory.getRandomTarget();
                System.out.println(character.getName() + " attacked " + target1.getName());
                character.attack(target1);
                Thread.sleep(5000);
            } else {
                    while (true) {
                        System.out.println("| Attack | Inventory | equip |");
                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        String instruction = reader.readLine();
                        if (instruction.equals("Inventory")){
                            gameFactory.Inventory();
                            System.out.println();
                        }
                        if (instruction.equals("equip")){
                            System.out.println("Choose the weapon to equip");
                            BufferedReader weapon = new BufferedReader(new InputStreamReader(System.in));
                            String weaponToEquip = weapon.readLine();
                            character.equip(gameFactory.getWeapon(weaponToEquip));
                        }
                        if (instruction.equals("Attack")){
                            System.out.println("Choose target");
                            BufferedReader target = new BufferedReader(new InputStreamReader(System.in));
                            String targetToAttack = target.readLine();
                            character.attack(gameFactory.getTarget(targetToAttack));
                            break;
                        }

                    }
            }
            character.waitTurn();
        }
    }
}
