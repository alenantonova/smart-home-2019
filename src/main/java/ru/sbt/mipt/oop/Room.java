package ru.sbt.mipt.oop;

import java.util.Collection;
import ru.sbt.mipt.oop.action.Action;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    public void execute(Action action) {
        if(action.get_area().equals("doors")) {
            for(Door door: doors) {
                action.run(door, name);
            }
        }

        if(action.get_area().equals("lights")) {
            for(Light light: lights) {
                action.run(light, name);
            }
        }
    }
}
