package com.github.cc3002.finalreality.model.weapon;

public class Bow extends Weapon {
    public Bow(final String name, final int damage, final int weight,
               final WeaponType type) {
        super(name, damage, weight, type, 0);
    }
}
