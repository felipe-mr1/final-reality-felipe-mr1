package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.util.concurrent.BlockingQueue;

public class BlackMage extends PlayerCharacter {

    int mana;
    int defensePoints;
    public BlackMage(final java.lang.String name,
                     final BlockingQueue<ICharacter> turnsQueue,
                     final String characterClass){
        super(name, turnsQueue, characterClass, 500);
        this.mana = 200;
        this.defensePoints = 100;
    }


    public void equip(IWeapon weapon) {
        weapon.equip(this);
        super.equip(weapon);
    }
    //public void equip(IWeapon weapon) throws Exception {
        //if (!(weapon instanceof Staff | weapon instanceof Knife)){
            //throw new Exception("Can't equip that type of weapon");
        //}
        //super.equip(weapon);
    //}


    // have to add the effect of thunder
    //public void thunder(ICharacter character){
        //assert this.mana>15;
        //this.mana -= 15;
        //double damage = this.getEquippedWeapon().getDamage();
        //character.setHealthPoints(damage);
    //}
    // have to add effect of fire
    //public int fire(ICharacter character){
        //assert this.mana>15;
        //this.mana -= 15;
        //return this.getEquippedWeapon().getMagicDamage();
    //}
}
