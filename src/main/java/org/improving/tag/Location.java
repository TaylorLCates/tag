package org.improving.tag;

import org.improving.tag.items.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "location")
public class Location {
    @Id
    private int id;
    @Column(name = "Name")
    private String name = "";
    @Column(name = "Description")
    private String description = "";
    @Transient
    private List<Exit> exits = new ArrayList<>();
    @Transient
    private Adversary adversary;
    @Column(name = "AdversaryId")
    private Long adversaryIdDB;
    @Transient
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;


    public Long getAdversaryIdDB() {
        return adversaryIdDB;
    }

    public void setAdversaryIdDB(Long adversaryIdDB) {
        this.adversaryIdDB = adversaryIdDB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adversary getAdversary() {
        return adversary;
    }

    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Exit> getExits() {
        return exits;
    }

    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }

    public String getTreasureDescription() {
        return treasureChest.getDescription();
    }

    public TreasureChest getTreasureChest() {
        return treasureChest;
    }

    public Item openTreasureChest() {
        if (treasureChest.NO_TREASURE.equals(treasureChest)) {
            throw new UnsupportedOperationException();
        }
        Item treasure = treasureChest.getItem();
        treasureChest = TreasureChest.NO_TREASURE;
        return treasure;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location location = (Location) obj;
            return this.getName().equals(location.getName());
        }
        return super.equals(obj);
    }

    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    //public void addExit(Exit exit) {
       // this.exit = exit;
    }


