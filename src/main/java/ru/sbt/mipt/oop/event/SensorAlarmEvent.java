package ru.sbt.mipt.oop.event;

import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.event.SensorEvent;

public class SensorAlarmEvent extends SensorEvent {
  private String code;

  public SensorAlarmEvent(SensorEventType type, String code) {
    super(type, "-1");
    this.code = code;
  }

  public String getCode() {return code;}
}
