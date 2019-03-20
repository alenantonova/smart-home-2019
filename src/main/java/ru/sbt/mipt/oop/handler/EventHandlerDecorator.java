package ru.sbt.mipt.oop.handler;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

import com.sun.xml.internal.ws.client.SenderException;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.ActiveState;
import ru.sbt.mipt.oop.alarm.AlarmState;

public class EventHandlerDecorator implements EventHandler {

  private EventHandler wrappee;

  public EventHandlerDecorator(EventHandler handler) {
    this.wrappee = handler;
  }

  @Override
  public void handleEvent (SmartHome smartHome, SensorEvent event) {
    if (smartHome.getAlarm().getState() instanceof ActiveState) {
      if(event.getType() != ALARM_ACTIVATE && event.getType() != ALARM_DEACTIVATE) {
        smartHome.getAlarm().changeState(new AlarmState(smartHome.getAlarm()));
        System.out.println("sending sms");
      } else {
        wrappee.handleEvent(smartHome, event);
      }
    } else if (smartHome.getAlarm().getState() instanceof AlarmState) {
        System.out.println("sending sms");
    } else {
      wrappee.handleEvent(smartHome, event);
    }

  }

}
