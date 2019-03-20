package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Light;

public class TurnOnLight implements Action<Light> {
  String light_id;
  String location;

  public TurnOnLight(String object_id) {
    light_id = object_id;
  }

  public String get_area() {
    return "lights";
  }

  public String get_location() {
    return location;
  }

  public void run(Light object, String room_name) {
    if(light_id.equals(object.getId()) || light_id.equals("all")) {
      object.setOn(true);
      location = room_name;
      System.out.println("Light " + object.getId() + " in room " + room_name + " was turned on.");
    }
  }

}
