package com.github.cc3002.finalreality.model.weapon;

public class Staff extends AbstractWeapon {
    private final int magicDamage;
    public Staff(final String name, final int damage, final int weight,
                  final String type,final int magicDamage){
        super(name, damage, weight, type, magicDamage);
        this.magicDamage = magicDamage;
    }
}
