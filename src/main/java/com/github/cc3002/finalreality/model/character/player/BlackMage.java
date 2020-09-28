package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Staff;

import java.util.concurrent.BlockingQueue;

public class BlackMage extends PlayerCharacter {
    private Staff equippedstaff = null;
    int mana;
    public BlackMage(final String name,
                     final BlockingQueue<ICharacter> turnsQueue,
                     final CharacterClass characterclass){
        super(name, turnsQueue, characterclass);
        this.mana = 200;
    }
    public void equipStaff(Staff astaff){
        this.equippedstaff = astaff;
    }
    public Staff getEquippedstaff(){
        return equippedstaff;
    }
    public int thunder(){
        assert this.mana>15;
        this.mana -= 15;
        return this.getEquippedstaff().getMagicDamage();
    }
    public int fire(){
        assert this.mana>15;
        this.mana -= 15;
        return this.getEquippedstaff().getMagicDamage();
    }
}
