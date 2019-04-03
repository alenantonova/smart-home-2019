package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.object.Door;
import ru.sbt.mipt.oop.object.Light;
import ru.sbt.mipt.oop.object.Room;

public class CloseHallDoorCommand extends Command {
    public CloseHallDoorCommand(SmartHome smarthome) {
        super(smarthome);
    }

    @Override
    public boolean execute() {
        for(Room room: smarthome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door : room.getDoors()) {
                    door.setOpen(false);
                }
            }

            for (Light light : room.getLights()) {
                light.setOn(false);
            }
        }
        return true;
    }
}
