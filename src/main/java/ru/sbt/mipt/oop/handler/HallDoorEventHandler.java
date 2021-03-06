package ru.sbt.mipt.oop.handler;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

import ru.sbt.mipt.oop.object.Door;
import ru.sbt.mipt.oop.object.Room;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.TurnOffLight;

public class HallDoorEventHandler implements EventHandler {
  public void handleEvent(SmartHome smartHome, SensorEvent event) {
    if (event.getType() == DOOR_CLOSED) {
      for (Room room: smartHome.getRooms()) {
        if (room.getName().equals("hall")) {
          for (Door door: room.getDoors()) {
            if (door.getId().equals(event.getObjectId())) {
              Action hall_action = new TurnOffLight("all");
              smartHome.execute(hall_action);
              break;
            }
          }
          break;
        }
      }
    }
  }
}


