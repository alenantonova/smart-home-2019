package ru.sbt.mipt.oop.handler;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public interface EventHandler {
  void handleEvent(SmartHome smartHome, SensorEvent event);

}
