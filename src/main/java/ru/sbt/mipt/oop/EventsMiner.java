package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.SensorEvent;

public interface EventsMiner {
  SensorEvent getNextSensorEvent();
}
