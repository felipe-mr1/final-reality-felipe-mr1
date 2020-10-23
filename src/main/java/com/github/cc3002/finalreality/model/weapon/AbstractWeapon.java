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
    private int magicDamage;

    protected AbstractWeapon(final String name, final int damage, final int weight,
                             final String type, final int magicDamage) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        this.type = type;
        this.magicDamage = magicDamage;
    }

    @Override
    public boolean equals(IWeapon weapon){
        if ((this.name.equals(weapon.getName()))&&(this.type.equals(weapon.getType()))){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {return Objects.hash(this.name) + Objects.hash(this.type);}

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

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void equip(ICharacter character) {character.equip(this);}

    @Override
    public void attack(ICharacter enemy) {
        int damage = this.damage - enemy.getDefensePoints();
        enemy.setHealthPoints(damage);
    }
    }
