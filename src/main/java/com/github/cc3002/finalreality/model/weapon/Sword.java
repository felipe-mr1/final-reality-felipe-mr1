package com.github.cc3002.finalreality.model.weapon;

public class Sword extends AbstractWeapon {
    public Sword(final String name, final int damage, final int weight,
               final String type) {
        super(name, damage, weight, type, 0);
    }
}
