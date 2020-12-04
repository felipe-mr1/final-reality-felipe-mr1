/*package com.github.cc3002.finalreality.model.Client;

import com.github.cc3002.finalreality.model.character.ICharacter;

import java.io.*;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Controller {*/


    /*public static void main(String args[]) throws IOException, InterruptedException {
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
    }*/

    /*public static void playerCreation(GameFactory gameFactory, PrintStream out, BufferedReader reader){
        Random rng = new Random();
        int i = 0;
        while(i<4) {
            //BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
            //BufferedReader characterClass = new BufferedReader(new InputStreamReader(System.in));
            //BufferedReader weaponName = new BufferedReader(new InputStreamReader(System.in));
            //BufferedReader type = new BufferedReader(new InputStreamReader(System.in));
            try {
                out.println("Choose character's name");
                String line = reader.readLine();
                if (line.length() == 0){break;}
                out.println("Choose class: | Black Mage | Engineer | Knight | Thief | White Mage |");
                String line1 = reader.readLine();
                out.println("Choose name of the weapon");
                String line2 = reader.readLine();
                out.println("Choose type of the weapon: | Axe | Bow | Knife | Staff | Sword |");
                String line3 = reader.readLine();
                var player = gameFactory.createPlayer(line, line1);
                var weapon= gameFactory.createWeapon(line2, rng.nextInt(10)+40, rng.nextInt(50), line3, 0);
                player.equip(weapon);
                player.waitTurn();
            } catch (IOException ignored){

            }
            i++;
        }
    }

    public static void enemyCreator(GameFactory gameFactory, PrintStream out){
        out.println("Creating enemies");
        Random rng = new Random();
        for (int j = 0; j < rng.nextInt(3) + 1; j++){
            var enemy= gameFactory.createEnemy("Enemy" + j, rng.nextInt(50));
            enemy.waitTurn();
        }
    }

    public static void run(GameFactory gameFactory, BlockingQueue<ICharacter> queue, PrintStream out, BufferedReader reader) throws IOException, InterruptedException {
        playerCreation(gameFactory, out, reader);
        enemyCreator(gameFactory, out);
        while (!(gameFactory.gameOver())){
            out.println("Party's health points");
            gameFactory.getPlayersHealthPoints();
            out.println();
            out.println("Enemies health points");
            gameFactory.getEnemiesHealthPoints();
            out.println();

            var character = queue.poll();
            while (character.getHealthPoints() == 0){
                character = queue.poll();
            }
            out.println("Turn of " + character.getName());
            if (character.getCharacterClass().equals("Enemy")){
                out.println("Enemy turn");
                var target1=gameFactory.getRandomTarget();
                out.println(character.getName() + " attacked " + target1.getName());
                character.attack(target1);
                Thread.sleep(3000);
            } else {
                while (true) {
                    out.println("| Attack | Inventory | equip |");
                    //BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
                    String instruction = reader.readLine();
                    if (instruction.equals("Inventory")){
                        gameFactory.Inventory();
                        out.println();
                    }
                    if (instruction.equals("equip")){
                        out.println("Choose the weapon to equip");
                        //BufferedReader weapon = new BufferedReader(new InputStreamReader(System.in));
                        String weaponToEquip = reader.readLine();
                        character.equip(gameFactory.getWeapon(weaponToEquip));
                    }
                    if (instruction.equals("Attack")){
                        out.println("Choose target");
                        //BufferedReader target = new BufferedReader(new InputStreamReader(System.in));
                        String targetToAttack = reader.readLine();
                        character.attack(gameFactory.getTarget(targetToAttack));
                        break;
                    }

                }
            }
            character.waitTurn();
        }
        out.println("Game over");
    }


    public static void run(GameFactory gameFactory, BlockingQueue<ICharacter> queue) throws IOException, InterruptedException {
        run(gameFactory, queue, System.out, new BufferedReader(new InputStreamReader(System.in)));
    }*/

    /**
     * Run for testing, does not print
     */
    /*public static void run(GameFactory gameFactory, BlockingQueue<ICharacter> queue, PrintStream out, String string) throws IOException, InterruptedException {
        run(gameFactory, queue, out, new BufferedReader(new StringReader(string)));
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BlockingQueue<ICharacter> queue = new LinkedBlockingQueue<>();
        GameFactory gameFactory = new GameFactory(queue);
        run(gameFactory, queue);
    }
}*/
