package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class Axe extends AbstractWeapon {
    public Axe(final String name, final int damage, final int weight,
               final String type){
        super(name, damage, weight, type, 0);
    }

    @Override
    public void equip(ICharacter character) {
        if ((character.getCharacterClass().equals("Engineer"))||(character.getCharacterClass().equals("Knight"))){
            int i = 0;
            i++;
        } else {
            int k = 0;
            k++;
        }
    }
}
