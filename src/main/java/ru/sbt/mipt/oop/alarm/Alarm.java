package ru.sbt.mipt.oop.alarm;

public class Alarm {
  private String code;
  private State state;
  boolean is_active;
  //boolean is_on_alarm;

  public boolean CheckCode(String combination) {
    return code.equals(combination);
  }

  public Alarm() {
    code = "0000";
    state = new DeActiveState(this);
    is_active = false;
  }

  public Alarm(String initial_code) {
    code = initial_code;
    state = new DeActiveState(this);
    is_active = false;
    //is_on_alarm = false;
  }

  public State getState() {
    return state;
  }

  public void set_active(boolean cur_active) {
    is_active = cur_active;
  }

  public void changeState(State state) {
    this.state = state;
  }

}
