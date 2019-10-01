package org.improving.tag.items;

public enum UniqueItems implements Item {

    THE_ONE_RING("A golden ring oozing with cheesy power"),
    BLUE_SHELL("A blue shell with bloodyopen white horns jutting out of its carapace. Metal."),
    NOTHING("") {
        public String getDescription() {
            throw new UnsupportedOperationException();
        }
    };

    private String description;

    UniqueItems(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}









