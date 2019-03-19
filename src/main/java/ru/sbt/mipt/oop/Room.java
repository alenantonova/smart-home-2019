package ru.sbt.mipt.oop;

import java.util.ArrayList;
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
        String action_type = action.getClass().getSimpleName();
        boolean result;

        Collection<String> door_actions = ActionsOnDoor();
        Collection<String> light_actions = ActionsOnLight();

        if(door_actions.contains(action_type)) {
            for (Door door : doors) {
                result = action.run(door);
                if (result) {
                    action.set_location(name);
                    action.print_result();
                }

            }
        }

        if (light_actions.contains(action_type)) {
            for (Light light : lights) {
                result = action.run(light);
                if (result) {
                    action.set_location(name);
                    action.print_result();
                }
            }
        }
    }

    private static Collection<String> ActionsOnDoor() {
        Collection<String> actions = new ArrayList<>();
        actions.add("CloseDoor");
        actions.add("OpenDoor");
        actions.add("GetDoorRoom");
        return actions;
    }

    private static Collection<String> ActionsOnLight() {
        Collection<String> actions = new ArrayList<>();
        actions.add("TurnOnLight");
        actions.add("TurnOffLight");
        return actions;
    }
}
