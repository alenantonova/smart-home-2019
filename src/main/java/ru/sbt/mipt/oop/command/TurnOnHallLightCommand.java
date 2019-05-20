package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.object.Light;
import ru.sbt.mipt.oop.object.Room;

public class TurnOnHallLightCommand implements Command {
    private SmartHome smarthome;

    public TurnOnHallLightCommand(SmartHome smarthome) {
        this.smarthome = smarthome;
    }

    public boolean execute() {
        for(Room room: smarthome.getRooms()) {
            if(room.getName().equals("hall")) {
                for (Light light : room.getLights()) {
                    light.setOn(true);
                }
            }
        }
        return true;
    }
}
