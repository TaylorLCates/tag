package org.improving.tag;

import org.improving.tag.items.Item;

public class Adversary {
    private String name;
    private int hitPoints;
    private int damageTaken;
    private int attackDamage;
    private Item item;

    public Adversary(String name, int hitPoints, Item item) {
        this.name = name;
        this.damageTaken = 0;
        this.attackDamage = 1;
        this.hitPoints = hitPoints;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void damageCalculation(int damageAmount) {
        hitPoints = hitPoints - damageAmount;
        damageTaken = damageTaken + damageAmount;
        }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

