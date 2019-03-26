package ru.sbt.mipt.oop.object.alarmstates;

import ru.sbt.mipt.oop.object.Alarm;

public class ActiveState extends State {

  public ActiveState(Alarm alarm) {
    super(alarm);
  }

  @Override
  public void Deactivate(String combination) {
    if(alarm.CheckCode(combination)) {
      alarm.deactivate();
    } else {
      alarm.alarm();
    }
  }

  @Override
  public void Activate(String combination) {

  }
}
