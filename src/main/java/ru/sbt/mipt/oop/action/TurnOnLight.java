package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Light;

public class TurnOnLight implements Action<Light> {
  String light_id;
  String location;
  String result;

  public TurnOnLight(String object_id) {
    location = "none";
    light_id = object_id;
    result = "none";
  }

  public void set_location(String location_name) {
    location = location_name;
  }

  public String get_location() {
    return location;
  }

  public void print_result() {
    System.out.println(result + " in room " + location + ".");
  }

  public boolean run(Light object) {
    if(light_id.equals(object.getId()) || light_id.equals("all")) {
      object.setOn(true);
      result = "Light " + object.getId() + " was turned on";
      return true;
    } else {
      return false;
    }
  }

}
