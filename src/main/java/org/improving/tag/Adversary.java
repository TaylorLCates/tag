package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity( name = "adversary")
public class Adversary {
    @Id
    long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "hitPoints")
    private int hitPoints;

    @Column(name = "DamageTaken")
    private int damageTaken;

    @Column(name = "AttackDamage")
    private int attackDamage;


    @Column(name = "DropItem")
    private UniqueItems item;

    @Transient
    private Item dropItem;



    public Adversary() {
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

    public void setItem(UniqueItems item) {
        this.item= item;
    }

//    @PostLoad
//    public void postLoad() {
//        System.out.println("Item is: " + item);
//    }

}

