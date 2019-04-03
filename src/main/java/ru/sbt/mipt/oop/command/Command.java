package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;

public abstract class Command {
    public SmartHome smarthome;

    Command(SmartHome smarthome) {
        this.smarthome = smarthome;
    }

    public abstract boolean execute();
}
