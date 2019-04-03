package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.object.Light;
import ru.sbt.mipt.oop.object.Room;

public class TurnOffAllLightCommand extends Command {

    public TurnOffAllLightCommand(SmartHome smarthome) {
        super(smarthome);
    }

    @Override
    public boolean execute() {
        for(Room room: smarthome.getRooms()) {
            for(Light light: room.getLights()) {
                light.setOn(false);
            }
        }
        return true;
    }
}
