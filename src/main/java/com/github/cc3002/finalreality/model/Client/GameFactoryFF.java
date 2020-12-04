package com.github.cc3002.finalreality.model.Client;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

public class GameFactoryFF {
    protected BlockingQueue<ICharacter> turns;

    public GameFactoryFF(BlockingQueue<ICharacter> turn){
        this.turns = turn;
    }

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

    public ICharacter createEnemy(String name, int weight){
        return new Enemy(name, weight, turns);
    }

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
