package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayer;

public class Staff extends AbstractWeapon {
    public Staff(final String name, final int damage, final int weight,
                  final String type,final int magicDamage){
        super(name, damage, weight, type, magicDamage);
    }
    @Override
    public void equip(IPlayer character) {character.equipStaff(this);}
}
