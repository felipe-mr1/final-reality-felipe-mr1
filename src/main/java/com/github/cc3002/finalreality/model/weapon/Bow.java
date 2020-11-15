package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayer;

public class Bow extends AbstractWeapon {
    public Bow(final String name, final int damage, final int weight,
               final String type) {
        super(name, damage, weight, type, 0);
    }

    @Override
    public void equip(IPlayer character) {character.equipBow(this);}
}
