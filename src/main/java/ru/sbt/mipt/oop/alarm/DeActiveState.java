package ru.sbt.mipt.oop.alarm;

public class DeActiveState extends State{

  DeActiveState(Alarm alarm) {
    super(alarm);
    alarm.set_active(false);

  }

  @Override
  public void Activate(String combination) {
    if (alarm.CheckCode(combination)) {
      alarm.changeState(new ActiveState(alarm));
    }
  }

  @Override
  public void Deactivate(String combination) {

  }




}
