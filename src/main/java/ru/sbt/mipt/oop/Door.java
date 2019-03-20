package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.action.Action;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public boolean isOpen() {return isOpen;}

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void execute(Action action) {
        action.run(this);
    }
}
