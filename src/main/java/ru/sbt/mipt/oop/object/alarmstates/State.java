package ru.sbt.mipt.oop.object.alarmstates;

import ru.sbt.mipt.oop.object.Alarm;

public abstract class State {
  Alarm alarm;

  State(Alarm init_alarm) {
    this.alarm = init_alarm;
  }

  public abstract void Activate(String combination);
  public abstract void Deactivate(String combination);
  //public abstract void onAlarm();

}
