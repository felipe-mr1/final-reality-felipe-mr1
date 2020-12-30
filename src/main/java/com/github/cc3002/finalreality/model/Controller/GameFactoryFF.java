package com.github.cc3002.finalreality.model.Controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

/**
 * Class in charge of creating all of the objects present in the game
 */

public class GameFactoryFF {
    protected BlockingQueue<ICharacter> turns;

    public GameFactoryFF(BlockingQueue<ICharacter> turn){
        this.turns = turn;
    }

    /**
     * Creates a playable character between the 5 classes to choose
     * @param name name of the character
     * @param characterClass class of the character
     * @return Playable character
     */
    public ICharacter createPlayer(String name, String characterClass){
        if (characterClass.equals("Black Mage")) {
            return new BlackMage(name, turns);
        }
        if (characterClass.equals("Engineer")){
            return new Engineer(name, turns);
        }
        if (characterClass.equals("Knight")){
            return new Knight(name, turns);
        }
        if (characterClass.equals("Thief")){
            return new Thief(name, turns);
        }
        if(characterClass.equals("White Mage")) {
            return new WhiteMage(name, turns);
        }
        return null;
    }

    /**
     * Creates an enemy
     * @param name name of the enemy
     * @param weight weight of the enemy
     * @return An enemy
     */
    public ICharacter createEnemy(String name, int weight){
        return new Enemy(name, weight, turns);
    }

    /**
     * Creates a weapon between 5 types of weapons to choose
     * @param name name of the weapon
     * @param damage damage of the weapon
     * @param weight weight of the weapon
     * @param type type of the weapon
     * @param magicDamage magic damage of the weapon
     * @return A weapon
     */
    public IWeapon createWeapon(String name, int damage, int weight, String type, int magicDamage){
        if (type.equals("Axe")){
            return new Axe(name, damage, weight, type);
        }
        if (type.equals("Bow")){
            return new Bow(name, damage, weight, type);
        }
        if (type.equals("Knife")){
            return new Knife(name, damage, weight, type);
        }
        if (type.equals("Staff")){
            return new Staff(name, damage, weight, type, magicDamage);
        }
        if (type.equals("Sword")) {
            return new Sword(name, damage, weight, type);
        }
        return null;
    }

}
