package ru.sbt.mipt.oop.alarm;

public class AlarmState extends State {

  public AlarmState(Alarm alarm) {
    super(alarm);
    alarm.set_active(true);
  }
  @Override
  public void Activate(String combination) {

  }

  @Override
  public void Deactivate(String combination) {

  }

}
