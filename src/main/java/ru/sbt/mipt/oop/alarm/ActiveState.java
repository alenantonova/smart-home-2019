package ru.sbt.mipt.oop.alarm;

public class ActiveState extends State {

  public ActiveState(Alarm alarm) {
    super(alarm);
    alarm.set_active(true);
  }

  @Override
  public void Deactivate(String combination) {
    if(alarm.CheckCode(combination)) {
      alarm.changeState(new DeActiveState(alarm));
    } else {
      alarm.changeState(new AlarmState(alarm));
    }
  }

  @Override
  public void Activate(String combination) {

  }
}
