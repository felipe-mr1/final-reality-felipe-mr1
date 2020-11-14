package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class Bow extends AbstractWeapon {
    public Bow(final String name, final int damage, final int weight,
               final String type) {
        super(name, damage, weight, type, 0);
    }

    @Override
    public void equip(ICharacter character) {character.equipBow(this);}
}
