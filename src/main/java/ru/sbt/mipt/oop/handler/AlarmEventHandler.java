package ru.sbt.mipt.oop.handler;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

import ru.sbt.mipt.oop.SensorAlarmEvent;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class AlarmEventHandler implements EventHandler {

  public void handleEvent(SmartHome smartHome, SensorEvent event) {
    if(event.getType().equals(ALARM_ACTIVATE)) {
      smartHome.getAlarm().getState().Activate(((SensorAlarmEvent) event).getCode());
    }

    if (event.getType().equals(ALARM_DEACTIVATE)) {
      smartHome.getAlarm().getState().Deactivate(((SensorAlarmEvent) event).getCode());
    }
  }

}
