package ru.sbt.mipt.oop.miner;

import ru.sbt.mipt.oop.event.SensorEvent;

public interface EventsMiner {
  SensorEvent getNextSensorEvent();
}
