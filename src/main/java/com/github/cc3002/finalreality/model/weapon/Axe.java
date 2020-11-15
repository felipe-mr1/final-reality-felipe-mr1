package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayer;

public class Axe extends AbstractWeapon {
    public Axe(final String name, final int damage, final int weight,
               final String type){
        super(name, damage, weight, type, 0);
    }

    @Override
    public void equip(IPlayer character) {character.equipAxe(this);}
}
