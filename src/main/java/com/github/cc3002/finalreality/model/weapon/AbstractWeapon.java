package com.github.cc3002.finalreality.model.weapon;

public abstract class AbstractWeapon implements IWeapon {
    private final String name;
    private final int damage;
    private final int weight;
    private final String type;
    private int magicDamage = 0;

    protected AbstractWeapon(final String name, final int damage, final int weight,
                             final String type, final int magicDamage) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        this.type = type;
        this.magicDamage = magicDamage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getMagicDamage() {return magicDamage;}

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    }
