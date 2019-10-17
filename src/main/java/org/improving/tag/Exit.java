package org.improving.tag;

import org.improving.tag.database.ListOfStrings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Arrays;
import java.util.List;
@Entity(name = "exits")
public class Exit {
    @Column(name = "Name")
    private String name;

    @OneToOne
    @JoinColumn(name = "DestinationId")
    private Location destination;

    @Column(name = "Aliases")
    private ListOfStrings aliases;

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OriginId")
    private Location origin;

//    @Column(name = "Aliases")
//    private String aliasesDB;

    public Exit() {

    }

    public Exit(String name, Location destination, String... aliases) {
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void addAlias(String alias) {
        this.aliases.add(alias);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Exit) {
            Exit exit = (Exit) obj;
            return this.getName().equals(exit.getName()) &&
                    this.getDestination().equals(exit.getDestination());
        }
        return super.equals(obj);
    }

//    @PostLoad
//    public void postLoad() {
//        String[] splitAliases = (aliasesDB.split(", "));
//        aliases = Arrays.asList(splitAliases);
//    }
}
