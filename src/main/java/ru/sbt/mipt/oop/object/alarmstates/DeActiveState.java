package ru.sbt.mipt.oop.object.alarmstates;

import ru.sbt.mipt.oop.object.Alarm;

public class DeActiveState extends State{

  public DeActiveState(Alarm alarm) {
    super(alarm);

  }

  @Override
  public void Activate(String combination) {
    if (alarm.CheckCode(combination)) {
      alarm.activate();
    }
  }

  @Override
  public void Deactivate(String combination) {

  }




}
