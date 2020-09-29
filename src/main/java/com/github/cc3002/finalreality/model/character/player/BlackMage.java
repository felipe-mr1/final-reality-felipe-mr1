package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Staff;
import com.github.cc3002.finalreality.model.weapon.Weapon;

import java.util.concurrent.BlockingQueue;

public class BlackMage extends PlayerCharacter {

    int mana;
    public BlackMage(final String name,
                     final BlockingQueue<ICharacter> turnsQueue,
                     final CharacterClass characterclass){
        super(name, turnsQueue, characterclass);
        this.mana = 200;
    }

    public void equip( Weapon weapon) throws Exception {
        if (!(weapon instanceof Staff | weapon instanceof Knife)){
            throw new Exception("Can't equip that type of weapon");
        }
        super.equip(weapon);
    }


    // have to add the effect of thunder
    public int thunder(){
        assert this.mana>15;
        this.mana -= 15;
        return this.getEquippedWeapon().getMagicDamage();
    }
    // have to add effect of fire
    public int fire(){
        assert this.mana>15;
        this.mana -= 15;
        return this.getEquippedWeapon().getMagicDamage();
    }
}
