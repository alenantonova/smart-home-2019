package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Door;

public class OpenDoor implements Action<Door> {
  String door_id;
  String location;


  public OpenDoor(String object_id) {
    door_id = object_id;
    location = "none";
  }

  public String get_area() {
    return "doors";
  }

  public String get_location() {
    return location;
  }

  public void run(Door object, String room_name) {
    if(door_id.equals(object.getId()) || door_id.equals("all")) {
      object.setOpen(true);
      location = room_name;
      System.out.println("Door " + object.getId() + " in room " + room_name + " was opened.");
    }
  }

}
