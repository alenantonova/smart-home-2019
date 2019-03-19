package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Door;

public class CloseDoor implements Action<Door> {
  String door_id;
  String location;
  String result;

  public CloseDoor(String object_id) {
    door_id = object_id;
    location = "none";
    result = "none";
  }

  public String get_location() {
    return location;
  }

  public void set_location(String location_name) {
    location = location_name;
  }

  public void print_result() {
    System.out.println(result + " in room " + location + ".");
  }

  public boolean run(Door object) {
    if(door_id.equals(object.getId()) || door_id.equals("all")) {
      object.setOpen(false);
      result = "Door " + object.getId() + " was closed";
      return true;
    } else {
      return false;
    }
  }
}
