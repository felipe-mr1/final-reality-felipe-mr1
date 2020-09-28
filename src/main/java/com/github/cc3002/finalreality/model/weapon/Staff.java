package com.github.cc3002.finalreality.model.weapon;

public class Staff extends Weapon{
    private final int magicDamage;
    public Staff(final String name, final int damage, final int weight,
                  final WeaponType type,final int magicDamage){
        super(name, damage, weight, type);
        this.magicDamage = magicDamage;
    }
    public int getMagicDamage(){
        return magicDamage;
    }
}
