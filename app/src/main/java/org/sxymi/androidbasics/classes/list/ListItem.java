package org.sxymi.androidbasics.classes.list;

public class ListItem {
    private int idString;

    private Class<?> target;

    public ListItem(int idString, Class<?> target) {
        this.idString = idString;
        this.target = target;
    }

    public int getIdString() {
        return this.idString;
    }

    public Class<?> getTarget() {
        return this.target;
    }
}
