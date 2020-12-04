/*package com.github.cc3002.finalreality.model.Client;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class GameFactory {
    protected BlockingQueue<ICharacter> turns;
    protected ArrayList<ICharacter> players = new ArrayList<>();
    protected ArrayList<ICharacter> enemies = new ArrayList<>();
    protected ArrayList<IWeapon> inventory = new ArrayList<>();

    public GameFactory(BlockingQueue turn){
        this.turns = turn;
    }

    public ICharacter createPlayer(String name, String characterClass){
        if (characterClass.equals("Black Mage")) {
            var player = new BlackMage(name, turns);
            players.add(player);
            return player;
        }
        if (characterClass.equals("Engineer")){
            var player = new Engineer(name, turns);
            players.add(player);
            return player;
        }
        if (characterClass.equals("Knight")){
            var player = new Knight(name, turns);
            players.add(player);
            return player;
        }
        if (characterClass.equals("Thief")){
            var player = new Thief(name, turns);
            players.add(player);
            return player;
        }
        if(characterClass.equals("White Mage")) {  // White Mage
            var player = new WhiteMage(name, turns);
            players.add(player);
            return player;
        }
        return null;
    }

    public ICharacter createEnemy(String name,int weight){
        var enemy = new Enemy(name, weight, turns);
        enemies.add(enemy);
        return enemy;
    }

    public IWeapon createWeapon(String name, int damage, int weight, String type, int magicDamage){
        if (type.equals("Axe")){
            var weapon = new Axe(name, damage, weight, type);
            inventory.add(weapon);
            return weapon;
        }
        if (type.equals("Bow")){
            var weapon = new Bow(name, damage, weight, type);
            inventory.add(weapon);
            return weapon;
        }
        if (type.equals("Knife")){
            var weapon = new Knife(name, damage, weight, type);
            inventory.add(weapon);
            return weapon;
        }
        if (type.equals("Staff")){
            var weapon = new Staff(name, damage, weight, type, magicDamage);
            inventory.add(weapon);
            return weapon;
        }
        if (type.equals("Sword")) {  // Sword
            var weapon = new Sword(name, damage, weight, type);
            inventory.add(weapon);
            return weapon;
        }
        return null;
    }

    public void Inventory(){
        for (IWeapon weapon : inventory){
            System.out.print(weapon.getName()+ "("+ weapon.getType()+ ")" + " ");
        }
    }

    public void getPlayersHealthPoints(){
        for (ICharacter player : players) {
            System.out.print("| "+ player.getName()+"("+player.getCharacterClass()+ ")" +" : "+player.getHealthPoints() + " | ");
        }
    }

    public void getEnemiesHealthPoints(){
        for (ICharacter enemy : enemies) {
            System.out.print("| " +enemy.getName() +" : "+enemy.getHealthPoints() + " | ");
        }
    }


    public boolean playersDead(){
        int i = players.size();
        int k = 0;
        for (int j = 0; j < i; j++){
            if (players.get(j).getHealthPoints() <= 0){
                k++;
            }
        }
        return k == i;
    }

    public boolean enemiesDead(){
        int i = enemies.size();
        int k = 0;
        for (int j = 0; j < i; j++){
            if (enemies.get(j).getHealthPoints() <= 0){
                k++;
            }
        }
        return k == i;
    }

    public boolean gameOver(){
        return this.playersDead() || this.enemiesDead();
    }

    public ICharacter getTarget(String target){
        for (ICharacter player : players){
            if (player.getName().equals(target)){
                return player;
            }
        }
        for (ICharacter enemy : enemies){
            if (enemy.getName().equals(target)){
                return enemy;
            }
        }
        return null;
    }

    public ICharacter getRandomTarget(){
        Random rng = new Random();
        int i = rng.nextInt(4);
        return players.get(i);
    }

    public IWeapon getWeapon(String weapon){
        for (IWeapon w : inventory){
            if (w.getName().equals(weapon)){
                return w;
            }
        }
        return null;
    }
}*/
