package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.Objects;


/**
 * An abstract class that holds the common behaviours of all the weapons in the game
 */
public abstract class AbstractWeapon implements IWeapon {
    private final String name;
    private final int damage;
    private final int weight;
    private final String type;
    private final int magicDamage;

    protected AbstractWeapon(final String name, final int damage, final int weight,
                             final String type, final int magicDamage) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        this.type = type;
        this.magicDamage = magicDamage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractWeapon)) return false;
        AbstractWeapon that = (AbstractWeapon) o;
        return damage == that.damage &&
                weight == that.weight &&
                magicDamage == that.magicDamage &&
                name.equals(that.name) &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, damage, weight, type, magicDamage);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getMagicDamage() {return magicDamage;}

    @Override
    public int getWeight() {
        return weight;
    }

    public String getType() {return type;}

    @Override
    public void attack(ICharacter enemy) {
        if (enemy.getHealthPoints()>0) {
            int damage = this.damage - enemy.getDefensePoints();
            enemy.setHealthPoints(damage);
        }
    }
    }
