package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class Sword extends AbstractWeapon {
    public Sword(final String name, final int damage, final int weight,
               final String type) {
        super(name, damage, weight, type, 0);
    }

    @Override
    public void equip(ICharacter character) {
        if ((character.getCharacterClass().equals("Thief"))||(character.getCharacterClass().equals("Knight"))){
            character.equipSword(this);
        } else {
            int k= 0;
            k++;
        }
    }
}
