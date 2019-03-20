package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Door;

public class CloseDoor implements Action<Door> {
  String door_id;
  String location;

  public CloseDoor(String object_id) {
    door_id = object_id;
    location = "none";
  }

  public String get_location() {
    return location;
  }

  public String get_area() {
    return "doors";
  }

  public void run(Door object, String room_name) {
    if(door_id.equals(object.getId()) || door_id.equals("all")) {
      object.setOpen(false);
      location = room_name;
      System.out.println("Door " + object.getId() + " in room " + room_name + " was closed.");

    }
  }
}
