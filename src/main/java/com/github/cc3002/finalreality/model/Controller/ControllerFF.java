package com.github.cc3002.finalreality.model.Controller;

import com.github.cc3002.finalreality.model.Controller.Phases.CreationPhase;
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

/**
 * A class that will control the actions of the characters and weapons
 */

public class ControllerFF implements PropertyChangeListener {
    protected GameFactoryFF gameFactoryFF;
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
    protected ArrayList<ICharacter> players = new ArrayList<>();
    protected ArrayList<ICharacter> activePlayers = new ArrayList<>();
    protected ArrayList<ICharacter> enemies = new ArrayList<>();
    protected ArrayList<IWeapon> inventory = new ArrayList<>();
    private Phase phase;
    private String attackedPlayer = null;

    /**
     * Constructor
     */
    public ControllerFF(){
        gameFactoryFF = new GameFactoryFF(turns);
        setPhase(new CreationPhase(this));
    }

    /**
     * Creates a player and adds it to a list
     * @param name of the character
     * @param characterClass class of the character
     */
    public void createPlayer(String name, String characterClass){
        if(players.contains(this.getPlayer(name))){return;}
        var player = gameFactoryFF.createPlayer(name, characterClass);
        if (player != null) {
            player.connect(this);
            players.add(player);
            activePlayers.add(player);
        }
    }

    /**
     * Creates an enemy and adds it to a list
     * @param name of the enemy
     * @param weight weight of the enemy
     */
    public void createEnemy(String name, int weight){
        var enemy = gameFactoryFF.createEnemy(name, weight);
        enemies.add(enemy);
    }

    /**
     * Creates a sets of enemies between 1 and 4
     */
    public void createEnemies(){
        Random rng = new Random();
        for(int e = 0; e < rng.nextInt(4) + 1; e++){
            createEnemy("Goblin" + e, rng.nextInt(15)+60);

        }
    }

    /**
     * Creates a Weapon and adds to a list (inventory)
     * @param name of the weapon
     * @param damage of the weapon
     * @param weight of the weapon
     * @param type of the weapon
     * @param magicDamage of the weapon
     */
    public void createWeapon(String name, int damage, int weight, String type, int magicDamage){
        var weapon = gameFactoryFF.createWeapon(name, damage, weight, type, magicDamage);
        inventory.add(weapon);
    }

    /**
     * Method to get the information of each weapon in the inventory
     * @return Information of each weapon
     */
    public String inventory(){
        StringBuilder bag = new StringBuilder();
        for (IWeapon weapon : inventory){
            bag.append("Name: ").append(weapon.getName()).append(" || Type: ").append(weapon.getType()).append(" || Damage: ").append(weapon.getDamage()).append(" || Magic Damage: ").append(weapon.getMagicDamage()).append(" || Weight: ").append(weapon.getWeight()).append(" \n\n");
        }
        return bag.toString();
    }

    /**
     * Method to equip a weapon
     * @param name of the character that will equip the weapon
     * @param weapon to equip
     */
    public void equip(String name, String weapon){
        this.getPlayer(name).equip(this.getWeapon(weapon));
    }

    /**
     * adds each character to a queue for the turns
     * @throws InterruptedException interrupted exception
     */
    public void addToQueue() throws InterruptedException {
        for (ICharacter player : players){
            player.waitTurn();
        }
        for (ICharacter enemy : enemies){
            enemy.waitTurn();
        }
        Thread.sleep(5000);
    }

    /**
     * Method used by the enemies to get a random player
     * from the party
     * @return a random active (alive) player from the party
     */
    private ICharacter getRandomTarget(){
        Random rng = new Random();
        int i = rng.nextInt(activePlayers.size());
        ICharacter target = players.get(i);
        this.attackedPlayer = target.getName();
        return target;
    }

    /**
     * Method that returns the most recent attacked player.
     * Helps to know who was the random target
     * @return the name of the most recent attacked player
     */
    public String getAttackedPlayer(){
        return this.attackedPlayer;
    }

    /**
     * Automatic attack from an enemy
     * @param enemy that will attack a random player
     */
    public void enemyTurn(ICharacter enemy){
        enemy.attack(this.getRandomTarget());
        enemy.waitTurn();
    }

    /**
     * Method to attacj a target
     * @param name of the character that will attack
     * @param target that the player will attack
     */
    public void attack(String name, String target){
        this.getPlayer(name).attack(this.getEnemy(target));
        this.getPlayer(name).waitTurn();
    }


    /**
     * Search in the list of players the character with the given name
     * @param target name of the character that will be searched
     * @return the character with the given name
     */
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

    /**
     * Search int the list of enemies the enemy with the given name
     * @param target name of the enemy
     * @return the enemy with given name
     */
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

    /**
     * Search inf the list of weapons (inventory) the weapon with the given name
     * @param weapon name of the weapon
     * @return the weapon with the given name
     */
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

    /**
     * Method that checks if all the players of the team are dead
     * @return boolean, true if all players are dead
     */
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

    /**
     * Checks if all enemies are dead
     * @return boolean, true if all enemies are dead
     */
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

    /**
     * Checks if either the players are dead or the enemies are dead
     * @return boolean, true if one of the conditions is true
     */
    public boolean gameOver(){
        return this.playersDead() || this.enemiesDead();
    }

    /**
     * Sets the current phase of the game
     * The phase delimits the dynamics of the game
     * @param phase that the game will be on
     */
    public void setPhase(Phase phase) {
        this.phase = phase;
        phase.setControllerFF(this);
    }

    /**
     * Gets the phase that is being currently used
     * @return Current phase
     */
    public Phase getPhase(){
        return phase;
    }

    /**
     * Used for the creation of players of the game
     * Delimited by the phase
     * @param aName name of the character
     * @param aClass class of the character
     * @param aWeapon TYPE of the weapon
     * @param aWeaponName name of the weapon
     */
    public void TryToCreatePlayer(String aName, String aClass, String aWeapon, String aWeaponName)  {
        try{
            phase.tryToCreatePlayer(aName, aClass, aWeapon, aWeaponName);
        } catch (InvalidActionException e) {
            e.printStackTrace();
        }

    }

    /**
     * String with the names of the characters that the user chose
     * @return String with the names of the party
     */
    public String getParty() {
        StringBuilder party = new StringBuilder(" ");
        for (ICharacter player : players){
            party.append(player.getName()).append(" ");
        }
        return party.toString();
    }

    /**
     * Value of the numbers of party members
     * @return number of party members
     */
    public int partySize() {
        return players.size();
    }

    /**
     * Forms a string with the information of the enemies
     * including names and health points for each one
     * @return String with the information of the enemies
     */
    public String getEnemies() {
        StringBuilder allEnemies = new StringBuilder();
        for (ICharacter enemy : enemies){
            allEnemies.append(enemy.getName()).append("  HP[").append(enemy.getHealthPoints()).append("]    ");
        }
        return allEnemies.toString();
    }

    /**
     * Forms a string with the information of the players
     * including names and health points for each one
     * @return String with the information of the players
     */
    public String getPartyInfo() {
        StringBuilder playersInfo = new StringBuilder();
        for (ICharacter player: players){
            playersInfo.append(player.getName()).append("  HP[").append(player.getHealthPoints()).append("]   ");
        }
        return playersInfo.toString();
    }

    /**
     * Gets the name of the next character in the queue
     * @return name the character that has to attack
     */
    public String getTurnOf() {
        ICharacter turn = turns.poll();
        String name;
        if (turn == null) return "";
        if (turn.getHealthPoints() == 0) return this.getTurnOf();
        name = turn.getName();
        return name;
    }

    /**
     * Sends a message to attack a given target
     * Delimited by the phase of the game
     * @param turnOf name of the character that will attack
     * @param target target that is being attacked
     */
    public void tryToAttack(String turnOf, String target) {
        try {
            phase.tryToAttack(turnOf, target);
        } catch (InvalidActionException e) {
            e.printStackTrace();
        }
    }

    /**
     * String that contains the info about the party
     * including character class, defense points and equipped weapon
     * @return String with the information about the party
     */
    public String getBattleInfo() {
        String info = "";
        for(ICharacter player : players){
            info += player.getName() +"--- Class: "+ player.getCharacterClass()
                    +"--- Defense Points:"+ player.getDefensePoints() +"--- Equipped Weapon: "+ player.getEquippedWeapon().getName()
                    +"["+player.getEquippedWeapon().getType()+"]"  + "\n\n";
        }
        return info;
    }

    /**
     * Sends a message to equip a weapon
     * @param currentTurn name of the character that will equip a weapon
     * @param text name of the weapon that will be equipped
     */
    public void tryToEquip(String currentTurn, String text) {
        try {
            phase.tryToEquip(currentTurn, text);
        } catch (InvalidActionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Value of how many enemies does the encounter presents
     * @return number of enemies
     */
    public int enemySize() {
        return enemies.size();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String name = (String) evt.getNewValue();
        activePlayers.remove(getPlayer(name));
    }
}
