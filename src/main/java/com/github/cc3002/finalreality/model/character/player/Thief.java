package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;

public class Thief extends PlayerCharacter {
    public Thief(final String name,
                    final BlockingQueue<ICharacter> turnsQueue,
                    final CharacterClass characterclass){
        super(name, turnsQueue, characterclass);
    }
}
