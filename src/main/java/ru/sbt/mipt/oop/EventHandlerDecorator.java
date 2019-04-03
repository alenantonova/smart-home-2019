package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.handler.EventHandler;
import ru.sbt.mipt.oop.object.alarmstates.ActiveState;
import ru.sbt.mipt.oop.object.alarmstates.AlarmState;

public class EventHandlerDecorator implements EventHandler {

  private EventHandler wrappee;

  public EventHandlerDecorator(EventHandler handler) {
    this.wrappee = handler;
  }

  @Override
  public void handleEvent (SmartHome smartHome, SensorEvent event) {
    if (smartHome.getAlarm().getState() instanceof ActiveState) {

        smartHome.getAlarm().alarm();
        System.out.println("sending sms");

    } else if (smartHome.getAlarm().getState() instanceof AlarmState) {
        System.out.println("sending sms");
    } else {
      wrappee.handleEvent(smartHome, event);
    }

  }

}
