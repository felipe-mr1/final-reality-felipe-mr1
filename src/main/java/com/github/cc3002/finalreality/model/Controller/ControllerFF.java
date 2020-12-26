package com.github.cc3002.finalreality.model.Controller;

import com.github.cc3002.finalreality.model.Controller.Phases.CreationPhase;
import com.github.cc3002.finalreality.model.Controller.Phases.GameOverPhase;
import com.github.cc3002.finalreality.model.Controller.Phases.InvalidActionException;
import com.github.cc3002.finalreality.model.Controller.Phases.Phase;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ControllerFF implements PropertyChangeListener {
    protected GameFactoryFF gameFactoryFF;
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
    protected ArrayList<ICharacter> players = new ArrayList<>();
    protected ArrayList<ICharacter> activePlayers = new ArrayList<>();
    protected ArrayList<ICharacter> enemies = new ArrayList<>();
    protected ArrayList<IWeapon> inventory = new ArrayList<>();
    private Phase phase;
    private String attackedPlayer = null;

    public ControllerFF(){
        gameFactoryFF = new GameFactoryFF(turns);
        setPhase(new CreationPhase(this));
    }

    public void createPlayer(String name, String characterClass){
        var player = gameFactoryFF.createPlayer(name, characterClass);
        if (player != null) {
            player.connect(this);
            players.add(player);
            activePlayers.add(player);
        }
    }

    public void createEnemy(String name, int weight){
        var enemy = gameFactoryFF.createEnemy(name, weight);
        enemies.add(enemy);
    }

    public void createEnemies(){
        Random rng = new Random();
        for(int e = 0; e < rng.nextInt(4) + 1; e++){
            createEnemy("Goblin" + e, rng.nextInt(15)+60);

        }
    }

    public void createWeapon(String name, int damage, int weight, String type, int magicDamage){
        var weapon = gameFactoryFF.createWeapon(name, damage, weight, type, magicDamage);
        inventory.add(weapon);
    }

    public String inventory(){
        StringBuilder bag = new StringBuilder();
        for (IWeapon weapon : inventory){
            bag.append("Name: ").append(weapon.getName()).append(" || Type: ").append(weapon.getType()).append(" || Damage: ").append(weapon.getDamage()).append(" || Magic Damage: ").append(weapon.getMagicDamage()).append(" || Weight: ").append(weapon.getWeight()).append(" \n\n");
        }
        return bag.toString();
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
        Thread.sleep(5000);
    }

    private ICharacter getRandomTarget(){
        Random rng = new Random();
        int i = rng.nextInt(activePlayers.size());
        ICharacter target = players.get(i);
        this.attackedPlayer = target.getName();
        return target;
    }

    public String getAttackedPlayer(){
        return this.attackedPlayer;
    }

    public void enemyTurn(ICharacter enemy){
        enemy.attack(this.getRandomTarget());
        enemy.waitTurn();
    }


    public void attack(String name, String target){
        this.getPlayer(name).attack(this.getEnemy(target));
        this.getPlayer(name).waitTurn();
    }


    public ICharacter getPlayer(String target){
        try {
            for (ICharacter player : players) {
                if (player.getName().equals(target)) {
                    return player;
                }
            }
        }
        catch (Exception e) {
            return null;
        }

        return null;
    }

    public ICharacter getEnemy(String target){
        try {
            for (ICharacter enemy : enemies) {
                if (enemy.getName().equals(target)) {
                    return enemy;
                }
            }
        }
        catch (Exception e) {
            return null;
        }

        return null;
    }

    public IWeapon getWeapon(String weapon) {
        try {
            for (IWeapon w : inventory) {
                if (w.getName().equals(weapon)) {
                    return w;
                }
            }
        } catch (Exception ignored) {
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
        setPhase(new GameOverPhase(this));
        return this.playersDead() || this.enemiesDead();
    }



    public void setPhase(Phase phase) {
        this.phase = phase;
        phase.setControllerFF(this);
    }

    public Phase getPhase(){
        return phase;
    }

    public void TryToCreatePlayer(String aName, String aClass, String aWeapon, String aWeaponName)  {
        try{
            phase.tryToCreatePlayer(aName, aClass, aWeapon, aWeaponName);
        } catch (InvalidActionException e) {
            e.printStackTrace();
        }

    }

    public String getParty() {
        StringBuilder party = new StringBuilder(" ");
        for (ICharacter player : players){
            party.append(player.getName()).append(" ");
        }
        return party.toString();
    }

    public int partySize() {
        return players.size();
    }

    public String getEnemies() {
        StringBuilder allEnemies = new StringBuilder();
        for (ICharacter enemy : enemies){
            allEnemies.append(enemy.getName()).append("  HP[").append(enemy.getHealthPoints()).append("]    ");
        }
        return allEnemies.toString();
    }

    public String getPartyInfo() {
        StringBuilder playersInfo = new StringBuilder();
        for (ICharacter player: players){
            playersInfo.append(player.getName()).append("  HP[").append(player.getHealthPoints()).append("]   ");
        }
        return playersInfo.toString();
    }

    public String getTurnOf() {
        ICharacter turn = turns.poll();
        String name;
        if (turn == null) return "";
        if (turn.getHealthPoints() == 0) return this.getTurnOf();
        name = turn.getName();
        return name;
    }


    public void tryToAttack(String turnOf, String s) {
        try {
            phase.tryToAttack(turnOf, s);
        } catch (InvalidActionException e) {
            e.printStackTrace();
        }
    }

    public String getBattleInfo() {
        String info = "";
        for(ICharacter player : players){
            info += player.getName() +"--- Class: "+ player.getCharacterClass()
                    +"--- Defense Points:"+ player.getDefensePoints() +"--- Equipped Weapon"+ player.getEquippedWeapon().getName()
                    +"["+player.getEquippedWeapon().getType()+"]"  + "\n\n";
        }
        return info;
    }

    public void tryToEquip(String currentTurn, String text) {
        try {
            phase.tryToEquip(currentTurn, text);
        } catch (InvalidActionException e) {
            e.printStackTrace();
        }
    }

    public int enemySize() {
        return enemies.size();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String name = (String) evt.getNewValue();
        activePlayers.remove(getPlayer(name));
    }
}
