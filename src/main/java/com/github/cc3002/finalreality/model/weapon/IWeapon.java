package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

public interface IWeapon {
    boolean equals(IWeapon weapon);

    String getName();

    int getDamage();

    int getMagicDamage();

    int getWeight();

    String getType();

    void equip(ICharacter character);
}
