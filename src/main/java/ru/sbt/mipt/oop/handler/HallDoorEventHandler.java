package ru.sbt.mipt.oop.handler;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.CloseDoor;
import ru.sbt.mipt.oop.action.TurnOffLight;

public class HallDoorEventHandler implements EventHandler {
  public void handleEvent(SmartHome smartHome, SensorEvent event) {
    if (event.getType() == DOOR_CLOSED) {
      Action action = new CloseDoor(event.getObjectId());
      smartHome.execute(action);
      if(((CloseDoor) action).GetRoom().equals("hall")) {
        Action hall_action = new TurnOffLight("all");
        smartHome.execute(hall_action);
      }

    }
  }
}


