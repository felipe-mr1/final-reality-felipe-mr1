package com.github.cc3002.finalreality.model.weapon;

public class Knife extends AbstractWeapon {
    public Knife(final String name, final int damage, final int weight,
               final String type) {
        super(name, damage, weight, type, 0);
    }
}
