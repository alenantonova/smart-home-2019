package ru.sbt.mipt.oop.handler;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.CloseDoor;
import ru.sbt.mipt.oop.action.OpenDoor;

public class DoorEventHandler implements EventHandler {

  public void handleEvent(SmartHome smartHome, SensorEvent event) {
    if(event.getType() == DOOR_OPEN) {
      Action action = new OpenDoor(event.getObjectId());
      smartHome.execute(action);
    } else if(event.getType() == DOOR_CLOSED) {
      Action action = new CloseDoor(event.getObjectId());
      smartHome.execute(action);
    }

  }

}
