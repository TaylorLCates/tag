package org.improving.tag.items;

public enum UniqueItems implements Item {

    THE_ONE_RING("The one Ring.","A golden ring oozing with cheesy power") {
    },
    BEYBLADE("A common Beyblade", "Super sick beyblade that was all the rage with the 12 year old crowd in the mid 2000s"),
    WEIRD_EARS("A pair of strange ears.", "Some weird looking ears. Idk, man."),
    FOX_EAR("Fox Ear","A fluffy red ear with a serrated bloody gash where it was \n brutally ripped off. Brings good luck!"),
    BLUE_SHELL("Blue Shell", "A blue shell with bloody white horns jutting out of its carapace. Metal."),
    NOTHING("", "") {
        public String getDescription() {
            throw new UnsupportedOperationException();
        }
    };

    @Override
    public String getName() {
        return name;
    }

    private String description;
    private String name;

    UniqueItems(String name, String description) {
        this.description = description;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}









