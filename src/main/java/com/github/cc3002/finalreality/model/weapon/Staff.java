package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

public class Staff extends AbstractWeapon {
    private final int magicDamage;
    public Staff(final String name, final int damage, final int weight,
                  final String type,final int magicDamage){
        super(name, damage, weight, type, magicDamage);
        this.magicDamage = magicDamage;
    }
    public void equip(ICharacter character) {
        if ((character.getCharacterClass().equals("Black Mage"))||(character.getCharacterClass().equals("Thief"))||(character.getCharacterClass().equals("White Mage"))){
            character.equipStaff(this);
        } else {
            int k = 0;
            k++;
        }
    }
}
