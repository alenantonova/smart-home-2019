package ru.sbt.mipt.oop.handler;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.TurnOffLight;
import ru.sbt.mipt.oop.action.TurnOnLight;

public class LightEventHandler implements EventHandler {

  public void handleEvent(SmartHome smartHome, SensorEvent event) {
    if(event.getType() == LIGHT_ON) {
      Action action = new TurnOnLight(event.getObjectId());
      smartHome.execute(action);
    } else if (event.getType() == LIGHT_OFF) {
      Action action = new TurnOffLight(event.getObjectId());
      smartHome.execute(action);
    }
  }
}
