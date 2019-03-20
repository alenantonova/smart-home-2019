package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Light;

public class TurnOffLight implements Action<Light> {
  String light_id;
  String location;

  public TurnOffLight(String object_id) {
    light_id = object_id;
    location = "none";
  }

  public String get_area() {
    return "lights";
  }

  public String get_location() {
    return location;
  }

  public void run(Light object, String room_name) {
    if(light_id.equals(object.getId()) || light_id.equals("all")) {
      object.setOn(false);
      location = room_name;
      System.out.println("Light " + object.getId() + " in room " + room_name + " was turned off.");
    }
  }

}
