package ru.sbt.mipt.oop.test;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.FileSmartHomeReader;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorAlarmEvent;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.ActiveState;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmState;
import ru.sbt.mipt.oop.alarm.DeActiveState;
import ru.sbt.mipt.oop.handler.AlarmEventHandler;
import ru.sbt.mipt.oop.handler.EventHandlerDecorator;

public class AlarmEventTest {

  SmartHome GetTestHome() throws IOException {
    FileSmartHomeReader reader = new FileSmartHomeReader();
    Alarm init_alarm = new Alarm("1234");
    SmartHome smarthome = reader.loadHome("smart-home-1.js");
    smarthome.set_alarm(init_alarm);
    return smarthome;
  }

  @Test
  public void SuccessfulAlarmDeactivate() throws IOException {

    SmartHome smarthome = GetTestHome();

    EventHandlerDecorator handler = new EventHandlerDecorator(new AlarmEventHandler());

    SensorEvent test_activate = new SensorAlarmEvent(ALARM_ACTIVATE, "1234");
    SensorEvent test_deactivate = new SensorAlarmEvent(ALARM_DEACTIVATE, "1234");

    handler.handleEvent(smarthome, test_activate);
    Assert.assertTrue(smarthome.getAlarm().getState() instanceof ActiveState);

    handler.handleEvent(smarthome, test_deactivate);
    Assert.assertTrue(smarthome.getAlarm().getState() instanceof DeActiveState);
  }

  @Test
  public void AlarmSituation() throws IOException {

    SmartHome smarthome = GetTestHome();
    EventHandlerDecorator handler = new EventHandlerDecorator(new AlarmEventHandler());

    SensorEvent test_activate = new SensorAlarmEvent(ALARM_ACTIVATE, "1234");
    SensorEvent test_deactivate = new SensorAlarmEvent(ALARM_DEACTIVATE, "1233");

    SensorEvent break_event =  new SensorEvent(DOOR_OPEN, "1");

    handler.handleEvent(smarthome, test_activate);
    handler.handleEvent(smarthome, test_deactivate);
    Assert.assertTrue(smarthome.getAlarm().getState() instanceof AlarmState);

    handler.handleEvent(smarthome, break_event);
    for (Room room: smarthome.getRooms()) {
      if (room.getName().equals("kitchen")) {
        for (Door door: room.getDoors()) {
          if (door.getId().equals("1")) {
            Assert.assertFalse(door.isOpen());
          }
        }
      }
    }
  }

}
