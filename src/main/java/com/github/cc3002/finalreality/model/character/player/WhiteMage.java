package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;

public class WhiteMage extends PlayerCharacter {
    double mana;
    public WhiteMage(final String name,
                     final BlockingQueue<ICharacter> turnsQueue,
                     final CharacterClass characterclass) {
        super(name, turnsQueue, characterclass);
        this.mana = 200;
    }
    public double heal(){
        assert this.mana > 15;
        this.mana -= 15;
        return 0.3;
    }
    public void poison(){
        assert this.mana > 40;
        this.mana -= 40;
    }
    public void paralyze(){
        assert this.mana > 30;
        this.mana -= 30;
    }
}
