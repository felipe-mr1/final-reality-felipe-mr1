package com.github.cc3002.finalreality.model.Client;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ControllerFF {
    protected GameFactoryFF gameFactoryFF;
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
    protected ArrayList<ICharacter> players = new ArrayList<>();
    protected ArrayList<ICharacter> enemies = new ArrayList<>();
    protected ArrayList<IWeapon> inventory = new ArrayList<>();

    public ControllerFF(){
        gameFactoryFF = new GameFactoryFF(turns);
    }

    public void createPlayer(String name, String characterClass){
        var player = gameFactoryFF.createPlayer(name, characterClass);
        players.add(player);
    }

    public void createEnemy(String name, int weight){
        var enemy = gameFactoryFF.createEnemy(name, weight);
        enemies.add(enemy);
    }

    public void createWeapon(String name, int damage, int weight, String type, int magicDamage){
        var weapon = gameFactoryFF.createWeapon(name, damage, weight, type, magicDamage);
        inventory.add(weapon);
    }

    public void inventory(PrintStream out){
        for (IWeapon weapon : inventory){
            out.print(weapon.getName()+ "("+ weapon.getType()+ ")" + " ");
        }
    }

    public void equip(String name, String weapon){
        this.getPlayer(name).equip(this.getWeapon(weapon));
    }

    public void addToQueue() throws InterruptedException {
        for (ICharacter player : players){
            player.waitTurn();
        }
        for (ICharacter enemy : enemies){
            enemy.waitTurn();
        }
        Thread.sleep(6000);
    }

    public ICharacter getRandomTarget(){
        Random rng = new Random();
        int i = rng.nextInt(4);
        return players.get(i);
    }

    private void enemyTurn(ICharacter enemy){
        enemy.attack(this.getRandomTarget());
        enemy.waitTurn();
    }

    public ICharacter getTurn(){
        var character = turns.poll();
        if (character.getHealthPoints() == 0){
            return null;
        }
        else if (character.getCharacterClass().equals("Enemy")){
            this.enemyTurn(character);
            return null;
        } else {
            return character;
        }
    }

    public void attack(String name, String target){
        this.getPlayer(name).attack(this.getEnemy(target));
        this.getPlayer(name).waitTurn();
    }

    public void getPlayersHealthPoints(PrintStream out){
        for (ICharacter player : players) {
            out.print("| "+ player.getName()+"("+player.getCharacterClass()+ ")" +" : "+player.getHealthPoints() + " | ");
        }
    }

    public void getEnemiesHealthPoints(PrintStream out){
        for (ICharacter enemy : enemies) {
            out.print("| " +enemy.getName() +" : "+enemy.getHealthPoints() + " | ");
        }
    }

    public ICharacter getPlayer(String target){
        for (ICharacter player : players){
            if (player.getName().equals(target)){
                return player;
            }
        }
        return null;
    }

    public ICharacter getEnemy(String target){
        for (ICharacter enemy : enemies){
            if (enemy.getName().equals(target)){
                return enemy;
            }
        }
        return null;
    }

    public IWeapon getWeapon(String weapon){
        for (IWeapon w : inventory){
            if (w.getName().equals(weapon)){
                return w;
            }
        }
        return null;
    }

    public boolean playersDead(){
        int i = players.size();
        int k = 0;
        for (ICharacter player : players) {
            if (player.getHealthPoints() <= 0) {
                k++;
            }
        }
        return k == i;
    }

    public boolean enemiesDead(){
        int r = 0;
        int e = enemies.size();
        for (ICharacter enemy : enemies) {
            if (enemy.getHealthPoints() <= 0) {
                r++;
            }
        }
        return r == e;
    }

    public boolean gameOver(){
        return this.playersDead() || this.enemiesDead();
    }
}
