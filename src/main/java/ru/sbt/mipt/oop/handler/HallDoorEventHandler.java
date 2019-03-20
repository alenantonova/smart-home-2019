package ru.sbt.mipt.oop.handler;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.GetDoorRoom;
import ru.sbt.mipt.oop.action.TurnOffLight;

public class HallDoorEventHandler implements EventHandler {
  public void handleEvent(SmartHome smartHome, SensorEvent event) {
    if (event.getType() == DOOR_CLOSED) {
      Action<Door> action = new GetDoorRoom(event.getObjectId());
      smartHome.execute(action);
      if(action.get_location().equals("hall")) {
        Action<Light> hall_action = new TurnOffLight("all");
        smartHome.execute(hall_action);
      }

    }
  }
}


