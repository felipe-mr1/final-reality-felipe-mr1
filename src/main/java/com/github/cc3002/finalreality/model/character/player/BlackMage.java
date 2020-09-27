package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;

public class BlackMage extends PlayerCharacter {
    int mana;
    public BlackMage(final String name,
                     final BlockingQueue<ICharacter> turnsQueue,
                     final CharacterClass characterclass){
        super(name, turnsQueue, characterclass);
        this.mana = 200;
    }
    public int thunder(){
        assert this.mana>15;
        this.mana -= 15;
        return 500;
    }
    public int fire(){
        assert this.mana>15;
        this.mana -= 15;
        return 600;
    }
}
